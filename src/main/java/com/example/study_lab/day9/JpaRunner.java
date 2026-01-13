package com.example.study_lab.day9;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JpaRunner implements CommandLineRunner {

    private final JpaExperimentService service;

    public JpaRunner(JpaExperimentService service){
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception{
        // Inteceptor 로그랑 섞이지 않게
        System.out.println("\n\n\n");
        service.experiment();
        System.out.println("\n\n\n");
    }
}
