package com.example.study_lab.day5;

import org.springframework.stereotype.Service;

// 내부 호출을 실험할 서비스
// - external() : 밖에서 부르는 메서드 (AOP 없음)
// - internal() : 안에서 불러지는 메서드 ( AOP 걸어봄)
@Service
public class SelfInvocationService {

    public void external(){
        System.out.println("1. [Service] external() 호출됨");
        System.out.println("2. [Service] 내부의 internal()을 호출합니다...");

        // Point : 자기 자신의 메서드를 호출 (this.internal())
        this.internal();
    }

    public void internal(){
        System.out.println("3. [Service] internal() 로직 수행 중...");
    }
}
