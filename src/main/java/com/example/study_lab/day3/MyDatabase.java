package com.example.study_lab.day3;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// DB 커넥션 풀을 만드는 라이브러리 개발 중일 경우, connect() 는 dbUrl 필드값이 반드시 있어야 동작한다.
//@Component
public class MyDatabase {

    @Value("${db.url}")
    private String dbUrl; // 필드 주입

    public MyDatabase(){
        // [A] 여기서 connect(); 호출
    }

    @PostConstruct // 전원을 켜는 단계/
    public void init(){
        // [B] 여기서 connect(); 호출.
    }
}

// A에서 connect() 호출하면 어떤 일?
// B에서 @Post~ 호출하는 것은 왜 안전?
// === "빈 껍데기(객체)는 생성되었지만, 내용물(의존성)은 아직 채워지지 않은 상태. -> 생성자에서는 절대 필드 주입된 변수 사용X
// A 지점 -> NPE :
// 1. 자바의 시간 : new MyDatabase()호출 : heap 메모리에 객체 생성 -> private String dbUrl; 초기화 X = null -> 생성자 내부 코드 실행 : connect()가 dbUrl을 참조하려함 -> null 참조 -> NPE
// 2. 스프링 시간 : 객체 생성이 끝난후, 스프링 컨테이너가 리플렉션으로 접근. @Value를 보고 dbUrl에 값을 채움.
// 3. 초기화 시간 : 모든 주입이 끝난후, 스프링이 init()호출 -> 안전.