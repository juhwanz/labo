package com.example.study_lab.day7;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChildService {

    @Transactional
    public void joinAndFail(){
        System.out.println("   -> [Child] 자식 트랜잭션 시작 (부모와 한 팀)");
        System.out.println("   -> [Child] 으악! 예외 발생");
        throw new RuntimeException("자식 로직 실패!");
    }
}
