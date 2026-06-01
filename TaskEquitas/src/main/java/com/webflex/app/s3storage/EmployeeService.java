package com.webflex.app.s3storage;
import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
@Service
public class EmployeeService {
	private final EmployeeRepository repo;
    private final S3Service s3Service;

    public EmployeeService(EmployeeRepository repo, S3Service s3Service) {
        this.repo = repo;
        this.s3Service = s3Service;
    }
	    // STEP 1: save Flux data to DB
	    public Flux<Employee> saveAll(Flux<Employee> employees) {
	        return repo.saveAll(employees)
	                .doOnNext(emp -> System.out.println("Saved: " + emp));
	    }

	    public Mono<Object> exportToExcelAndUpload() {

	        return repo.findAll()
	                .collectList()
	                .flatMap(list ->
	                Mono.<byte[]>fromCallable(() -> {

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

	                }).subscribeOn(Schedulers.boundedElastic())
	            );
	    }
}
