package com.example.study_lab.day2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ScopeTestRunner implements CommandLineRunner {

    private final SingletonBean singletonBean1;
    private final SingletonBean singletonBean2;

    public ScopeTestRunner(SingletonBean singletonBean1, SingletonBean singletonBean2) {
        this.singletonBean1 = singletonBean1;
        this.singletonBean2 = singletonBean2;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n========== [Day 2] Scope Trap 실험 시작 ==========");

        // 시나리오:
        // 사용자 A가 요청을 보냄 -> logic() 수행
        System.out.println("1. Client A call logic()");
        int count1 = singletonBean1.logic();
        System.out.println("   -> Count: " + count1);

        // 사용자 B가 요청을 보냄 -> logic() 수행
        // 기대: ProtoBean은 프로토타입이니까 새로 생성돼서 count가 1이어야 함.
        System.out.println("2. Client B call logic()");
        int count2 = singletonBean2.logic();
        System.out.println("   -> Count: " + count2);

        System.out.println("========== 실험 종료 ==========\n");
    }
}
