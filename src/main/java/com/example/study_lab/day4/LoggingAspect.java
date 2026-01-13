package com.example.study_lab.day4;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


// AOP
// RealService가 일할 때 몰래 끼어들어 로그 남기는 역.
@Aspect
//@Component
public class LoggingAspect {

    // day4 패키지 밑에 있는 모든 메서드 실행 전에 가로채라
    @Before("execution(* com.example.study_lab.day4..*(..))")
    public void logBefore(){
        System.out.println(" [감시자] 메서드가 곧 실행됩니다.");
    }
}
