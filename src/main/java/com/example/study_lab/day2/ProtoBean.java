package com.example.study_lab.day2;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // 요청시 마다 새로 생성
public class ProtoBean {
    private int count = 0;

    public ProtoBean(){
        System.out.println("Create ProtoBean");
    }

    @PostConstruct
    public void init(){
        System.out.println("ProtoBean.init " + this);
    }

    @PreDestroy
    public void destroy(){
        System.out.println("ProtoBean.destroy");
    }

    public void addCount(){
        count++;
    }

    public int getCount(){
        return count;
    }
}
