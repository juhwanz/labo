package com.example.study_lab.day7;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParentService {

    private final ChildService childService;

    public ParentService(ChildService childService){
        this.childService = childService;
    }

    @Transactional // 부모 Tx
    public void flow(){
        System.out.println("1. [Parent] 부모 트랜잭션 시작");

        try{
            // 자식 호출 (여기서 에러 터짐)
            childService.joinAndFail();
        }catch (RuntimeException e){
            // 부모가 예외 잡음
            System.out.println("2. [Parent] 자식이 던진 예외를 잡았습니다: " + e.getMessage());
            System.out.println("3. [Parent] 예외를 잡았으니 정상 커밋을 시도합니다...");
        }

        System.out.println("4. [Parent] 로직 종료 (이 뒤에 커밋이 일어남)");
    }
}
