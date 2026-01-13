package com.example.study_lab.day1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetterService {

    // final 금지
    private DataBaseRepository repository;

    // Setter 주입
    @Autowired
    public void setRepository(DataBaseRepository dataBaseRepository){
        this.repository = repository;
    }

    public void doBusinessLogic(){
        System.out.println("[SetterService] 로직 실행 중...");
        // 누군가 set을 안해주면 여기서 NPE(NUllPointerException)터짐
        repository.save();
    }
}
