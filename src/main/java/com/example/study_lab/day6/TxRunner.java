package com.example.study_lab.day6;

// TransactionAspectSupport라는 도구를 써서 지금 롤백 마킹이 되었나 훔쳐보기.

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TxRunner implements CommandLineRunner {

    private final TxService txService;

    public TxRunner(TxService txService){
        this.txService = txService;
    }

    @Override
    public void run(String... args) throws Exception{
        System.out.println("\n========== [Day 6] 트랜잭션 롤백 실험 ==========");

        // 1. RuntimeException 실험
        try{
            txService.errorRuntime();
        }catch (RuntimeException e){
            System.out.println("[결과 1] RuntimeException 발생함.");
            // 원래 DB를 조회 해야 하지만, 여기서는 이론 검증을 위해 메시지만 확인
            System.out.println(" 스프링 기본 : 런타임 예외는 자동 롤백");
        }

        System.out.println("------------------------------------------------");

        // 2. Checked Exception(IOException) 실험
        try{
            txService.errorChecked();
        }catch(Exception e){
            System.out.println("[결과 2] IOException 발생함.");
            System.out.println(" -> 스프링 기본 원칙: 체크 예외는 롤백 안 함 (X) -> 커밋됨!");
        }

        System.out.println("========== 실험 종료 ==========\n");
    }
}
