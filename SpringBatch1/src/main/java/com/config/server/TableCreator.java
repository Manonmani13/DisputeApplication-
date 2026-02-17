package com.config.server;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class TableCreator {

    private final JdbcTemplate jdbcTemplate;

    public TableCreator(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void createTable() {
        jdbcTemplate.execute("""
            CREATE TABLE IF NOT EXISTS employee_salary (
                id INT PRIMARY KEY,
                emp_name VARCHAR(100),
                salary DOUBLE,
                tax DOUBLE
            )
        """);
    }
}
