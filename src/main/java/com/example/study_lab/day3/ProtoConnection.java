package com.example.study_lab.day3;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// 프로토 타입 빈
@Component
@Scope("prototype")
public class ProtoConnection {

    public ProtoConnection(){
        System.out.println("A. [Prototype] 생성자 호출");
    }

    @PostConstruct
    public void init(){
        System.out.println("B. [Prototype] @PostConstruct 호출");
    }

    @PreDestroy
    public void close(){
        System.out.println("C. [Prototype] @PreDestroy 호출 (이게 찍힐까?)");
    }
}
