package com.example.study_lab.day10;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class NPlusOneRunner implements CommandLineRunner {
    private final NPlusOneService service;

    public NPlusOneRunner(NPlusOneService service){
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception{
        service.setup();        // 데이터 준비
        service.runPlusOne();   // 지옥 체험
        System.out.println("\n\n--------------------------------------\n\n");
        service.runFetchJoin(); // 천국 체험
    }
}
