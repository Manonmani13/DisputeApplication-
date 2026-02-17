package com.config.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    private final JobRunner jobRunner;

    public StartupRunner(JobRunner jobRunner) {
        this.jobRunner = jobRunner;
    }

    @Override
    public void run(String... args) throws Exception {
        jobRunner.run();
    }
}

