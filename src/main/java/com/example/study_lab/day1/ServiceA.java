package com.example.study_lab.day1;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/*@Service
@RequiredArgsConstructor // final이 붙은 필드를 모아서 생성자를 자동으로 만들어줌 (Lombok)
public class ServiceA {

    // 불변성 보장
    private final ServiceB serviceB;

    // 생성자 : 스프링이 이 클래스 만들 시 호출
    // 나를 만들기 위해 serviceB 내놔라고 특정. -> RequiredArgsConstructor로 지워짐.
    /*public ServiceA(@Lazy ServiceB serviceB){
        this.serviceB = serviceB;

        // 로그 확인: 진짜 객체인지 가짜(CGLIB Proxy)인지 출력
        System.out.println("================");
        System.out.println("ServiceA 생성됨.");
        System.out.println("주입받은 ServiceB의 클래스 이름: " + serviceB.getClass().getName());
        System.out.println("================");
    }*/

    /*public void sayHello(){
        System.out.println("Hello from A");
    }
}*/
