package com.example.study_lab.day3;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 싱글톤 생명주기 빈
// 서버에서 연결하는 척하는 클래스 : 생성자, Setter(Di 시점 확인용), 초기화, 종료 메서드 모드 로그에 넣는다.
@Component
public class ServerConnection {

    private String url;

    // 1. 생성자
    public ServerConnection(){
        System.out.println("1. [Singleton] 생성자 호출: url = " + url);
    }

    // 2. DI (Setter 주입을 통해 시점 확인)
    @Autowired
    public void setUrl(@Value("http://naver.com") String url){
        System.out.println("2. [Singleton] 의존성 주입(Setter) 호출: url 입력됨");
        this.url = url;
    }

    // 3. 초기화 콜백
    @PostConstruct
    public void init(){
        System.out.println("3. [Singleton] @PostConstruct 호출: 연결 시작 (url = " + url + ")");
    }

    // 4. 소멸 콜백
    @PreDestroy
    public void close(){
        System.out.println("4. [Singleton] @PreDestroy 호출: 연결 종료");
    }
}
