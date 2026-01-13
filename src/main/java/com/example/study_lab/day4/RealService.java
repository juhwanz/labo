package com.example.study_lab.day4;

import org.springframework.stereotype.Service;

// 아무런 기능이 없는 순수한 클래스
@Service
public class RealService {
    public void doSomething(){
        System.out.println(">>> 진짜 객체 : do.....");
    }
}
