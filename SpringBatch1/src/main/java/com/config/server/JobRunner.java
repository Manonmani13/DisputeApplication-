package com.config.server;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Component;

@Component
public class JobRunner {
	
	  private final JobLauncher jobLauncher;
	    private final Job salaryJob;

	    public JobRunner(JobLauncher jobLauncher, Job salaryJob) {
	        this.jobLauncher = jobLauncher;
	        this.salaryJob = salaryJob;
	    }

	    public void run() throws Exception {

	        JobParameters params = new JobParametersBuilder()
	                .addLong("run.id", System.currentTimeMillis())
	                .toJobParameters();

	        jobLauncher.run(salaryJob, params);
	    }

}
