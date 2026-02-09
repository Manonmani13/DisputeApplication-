package com.example.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/students")
    public ResponseEntity<byte[]> downloadReport() {

        byte[] pdf = reportService.generateStudentReport();

        return ResponseEntity.ok()
                .header("Content-Disposition",
                        "attachment; filename=students.pdf")
                .body(pdf);
    }
}
