package com.example.study_lab.day5;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Day5Aspect {
    // SelfInvocationService의 internal() 메서드만 정확히 노려서 감시
    @Before("execution(* com.example.study_lab.day5.SelfInvocationService.internal(..))")
    public void logBefore() {
        System.out.println(" [감시자] AOP 발동! internal()을 감시했습니다.");
    }
}
