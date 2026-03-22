package com.config.server;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {
	  @Bean
	    public FlatFileItemReader<Employee> employeeReader() {

	        FlatFileItemReader<Employee> reader = new FlatFileItemReader<>();
	        reader.setResource(new ClassPathResource("employees.csv"));
	        reader.setLinesToSkip(1);

	        reader.setLineMapper(new DefaultLineMapper<>() {{
	            setLineTokenizer(new DelimitedLineTokenizer() {{
	                setNames("id", "name", "salary");
	            }});
	            setFieldSetMapper(fieldSet -> {
	                Employee employee = new Employee();
	                employee.setId(fieldSet.readInt("id"));
	                employee.setName(fieldSet.readString("name"));
	                employee.setSalary(fieldSet.readDouble("salary"));
	                return employee;
	            });
	        }});

	        return reader;
	    }
	  @Bean
	    public ItemProcessor<Employee, Employee> employeeProcessor() {
	        return employee -> {

	            // Skip invalid salary
	            if (employee.getSalary() <= 0) {
	                return null;
	            }

	            // Calculate tax
	            double tax = employee.getSalary() * 0.10;
	            employee.setTax(tax);

	            return employee;
	        };
	    }
	  @Bean
	    public JdbcBatchItemWriter<Employee> employeeWriter(DataSource dataSource) {

	        JdbcBatchItemWriter<Employee> writer = new JdbcBatchItemWriter<>();

	        writer.setDataSource(dataSource);
	        writer.setSql(

	                "INSERT INTO employee_salary (id, emp_name, salary, tax) " +
	                "VALUES (:id, :name, :salary, :tax)"
	        );

	        writer.setItemSqlParameterSourceProvider(
	                new BeanPropertyItemSqlParameterSourceProvider<>()
	        );

	        return writer;
	    }

	  @Bean
	    public Step salaryStep(JobRepository jobRepository,
	                           PlatformTransactionManager transactionManager,
	                           DataSource dataSource) {

	        return new StepBuilder("salaryStep", jobRepository)
	                .<Employee, Employee>chunk(2, transactionManager)
	                .reader(employeeReader())
	                .processor(employeeProcessor())
	                .writer(employeeWriter(dataSource))
	                .build();
	    }
	  
	  @Bean
	    public Job salaryJob(JobRepository jobRepository, Step salaryStep) {

	        return new JobBuilder("salaryJob", jobRepository)
	                .start(salaryStep)
	                .build();
	    }
}
