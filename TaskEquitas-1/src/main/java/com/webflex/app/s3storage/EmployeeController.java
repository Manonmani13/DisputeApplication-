package com.webflex.app.s3storage;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;
    
    public EmployeeController(EmployeeService service) {
    	this.service=service;
    }

    // Save Flux data
    @PostMapping
    public Flux<Employee> save(@RequestBody Flux<Employee> employees) {
        return service.saveAll(employees);
    }

    // Export + File + Upload
    @GetMapping("/export")
    public Mono<String> export() {
        return service.exportToFile();
    }
}
