package com.example.study_lab.day1;

import org.springframework.stereotype.Repository;

@Repository
public class DataBaseRepository {
    public void save(){
        System.out.println(">>> 데이터 저장 완료");
    }
}
