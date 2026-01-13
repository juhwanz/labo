package com.example.study_lab.day5;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SelfInvocationRunner implements CommandLineRunner {

    private final SelfInvocationService service;

    public SelfInvocationRunner(SelfInvocationService service){
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception{
        System.out.println("\n========== [Day 5] 내부 호출 실험 시작 ==========");

        // external()을 실행하지만 internal()도 실행 됨.
        // internal()이 실행 될 시, [감시자] 로그 뜸? 안뜨네

        service.external();

        System.out.println("========== 실험 종료 ==========\n");
    }
}
