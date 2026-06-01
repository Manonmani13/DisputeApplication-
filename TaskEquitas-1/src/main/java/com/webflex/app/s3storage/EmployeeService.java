package com.webflex.app.s3storage;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class EmployeeService {
	 private final EmployeeRepository repository;
	    private final S3Service s3Service;

	    public EmployeeService(EmployeeRepository repository, S3Service s3Service) {
	    	this.repository=repository;
	    	this.s3Service=s3Service;
	    }
	    // STEP 1: save Flux data to DB
	    public Flux<Employee> saveAll(Flux<Employee> employees) {
	        return repository.saveAll(employees)
	                .doOnNext(emp -> System.out.println("Saved: " + emp));
	    }

	    public Mono<String> exportToExcelAndUpload() {

	        return repository.findAll()
	                .collectList()
	                .flatMap(list -> {

	                    return Mono.fromCallable(() -> {

	                        Workbook workbook = new XSSFWorkbook();
	                        Sheet sheet = workbook.createSheet("Employees");

	                        Row header = sheet.createRow(0);
	                        header.createCell(0).setCellValue("ID");
	                        header.createCell(1).setCellValue("Name");
	                        header.createCell(2).setCellValue("Department");

	                        int rowNum = 1;
	                        for (Employee e : list) {
	                            Row row = sheet.createRow(rowNum++);
	                            row.createCell(0).setCellValue(e.getId());
	                            row.createCell(1).setCellValue(e.getName());
	                            row.createCell(2).setCellValue(e.getDepartment());
	                        }

	                        ByteArrayOutputStream out = new ByteArrayOutputStream();
	                        workbook.write(out);
	                        workbook.close();

	                        return out.toByteArray();

	                    }).subscribeOn(Schedulers.boundedElastic());
	                })
	                .flatMap(bytes ->
	                        s3Service.uploadFile("employees.xlsx", bytes)
	                                .thenReturn(bytes)
	                )
	                .map(bytes -> s3Service.generateUrl("employees.xlsx"));
	    }
}
