package com.example.study_lab.day1;

import org.springframework.stereotype.Service;

@Service
public class ConstructorService {

    // final 사용 함으로써 불변성 보장
    private final DataBaseRepository repository;

    // 생성자에서 강제함(누락 불가능)
    public ConstructorService(DataBaseRepository repository){
        this.repository = repository;
    }

    public void doBusinessLogic(){
        System.out.println("[ConstructorService] 로직 실행중");
        repository.save();
    }
}
