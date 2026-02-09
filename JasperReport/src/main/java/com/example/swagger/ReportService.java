package com.example.swagger;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
@Service
public class ReportService {
    @Autowired
    private StudentRepository studentRepository;


	public byte[] generateStudentReport() {
		// TODO Auto-generated method stub
		try {
			List<Student> students = List.of(
	                createStudent(1L, "Alice", 85),
	                createStudent(2L, "Bob", 92),
	                createStudent(3L, "Charlie", 78),
	                createStudent(4L, "David", 90)
	            );

			//			List<Student> students=studentRepository.findAll();
			JRBeanCollectionDataSource jbc=new JRBeanCollectionDataSource(students);
			Map<String,Object> params=new HashMap<String, Object>();
            params.put("schoolName", "ABC International School");
             InputStream template =
            	    getClass().getClassLoader()
                    .getResourceAsStream("report/student_report.jrxml");

            JasperReport report =
                    JasperCompileManager.compileReport(template);

                // 5. Fill
                JasperPrint print =
                    JasperFillManager.fillReport(report, params, jbc);

                // 6. Export
                return JasperExportManager.exportReportToPdf(print);

		}
		catch (Exception e) {
            throw new RuntimeException(e);
		}
	}
	 private Student createStudent(Long id, String name, Integer marks) {
	        Student s = new Student();
	        s.setId(id);
	        s.setName(name);
	        s.setMarks(marks);
	        return s;
	    }

}
