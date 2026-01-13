package com.example.study_lab.day1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DiTestRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n========== [Day 1] DI 방식 비교 실험 시작 ==========");

        // 1. [Setter 주입의 위험성 증명]
        // 상황: 개발자가 실수로 의존성 주입(setRepository)을 까먹고 바로 메서드를 호출함
        System.out.println("1. SetterService 테스트 (실수 시나리오)");
        SetterService badService = new SetterService();
        // badService.setRepository(new DatabaseRepository()); // <-- 이걸 실수로 빼먹음!

        try {
            badService.doBusinessLogic(); // 실행!
        } catch (NullPointerException e) {
            System.out.println("   [결과] 펑! 예외 발생: " + e.getClass().getSimpleName());
            System.out.println("   -> 이유: Setter는 의존성을 강제하지 못해서 객체가 불완전한 상태로 생성됨.");
        }

        System.out.println("--------------------------------------------------");

        // 2. [Constructor 주입의 안전성 증명]
        System.out.println("2. ConstructorService 테스트 (실수 시나리오)");

        // 아래 주석을 해제해보세요. 빨간 줄(컴파일 에러)이 뜨나요?
        // ConstructorService goodService = new ConstructorService();

        System.out.println("   [결과] 컴파일 에러 발생!");
        System.out.println("   -> 이유: 생성자는 의존성을 넣지 않으면 아예 코드 작성이 안 됨.");

        // 올바른 사용법
        ConstructorService goodService = new ConstructorService(new DataBaseRepository());
        goodService.doBusinessLogic();

        System.out.println("========== 실험 종료 ==========\n");
    }
}
