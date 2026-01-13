package com.example.study_lab.day7;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PropagationRunner implements CommandLineRunner {

    private final ParentService parentService;

    public PropagationRunner(ParentService parentService){
        this.parentService = parentService;
    }

    @Override
    public void run(String... args) throws Exception{
        System.out.println("\n========== [Day 7] 전파 속성(REQUIRED) 실험 ==========");

        try{
            parentService.flow();
        }catch(Exception e){
            System.out.println("\n[최종 결과] 부모가 예외를 잡았음에도 불구하고 에러 발생!");
            System.out.println("에러 이름 : " + e.getClass().getSimpleName());
        }

        System.out.println("========== 실험 종료 ==========\n");
    }
}
