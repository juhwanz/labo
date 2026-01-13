package com.example.study_lab.day4;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProxyTestRunner implements CommandLineRunner {

    private final RealService realService;

    public ProxyTestRunner(RealService realService) {
        this.realService = realService;
    }

    @Override
    public void run(String... args) throws Exception{
        System.out.println("\n========== [Day 4] Proxy 탐정 놀이 ==========");

        // 메서드 실행 (감시자가 잘 끼어드는지)
        realService.doSomething();

        System.out.println("---------------------------------------------");

        // 진짜 realService가 많은지 확인

        System.out.println("객체 클래스 이름: " + realService.getClass().getName());

        System.out.println("========== 실험 종료 ==========\n");
    }
}
