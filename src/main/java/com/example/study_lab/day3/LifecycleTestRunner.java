package com.example.study_lab.day3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class LifecycleTestRunner implements CommandLineRunner {

    private final ApplicationContext context;

    public LifecycleTestRunner(ApplicationContext context){
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception{
        System.out.println("\n========== [Day 3] Lifecycle 실험 시작 ==========");

        // 싱글톤은 이미 앱 뜰 때 만들어졌음 (로그 상단 확인 필요)

        System.out.println(">> 프로토타입 빈 요청!");
        ProtoConnection proto1 = context.getBean(ProtoConnection.class);
        ProtoConnection proto2 = context.getBean(ProtoConnection.class);

        System.out.println("========== 앱 실행 중... (곧 종료됩니다) ==========\n");
        // run 메서드가 끝나면 Spring Boot 앱이 종료되면서 빈들이 소멸하기 시작함
    }
}
