package com.example.study_lab.day9;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // JPA는 기본 생성자 필수 (protected 권장)
    protected Member(){}

    public Member(String name){
        this.name = name;
    }

    public void changeName(String name){
        this.name = name;
    }

    public Long getId() {
        return id;}
    public String getName(){
        return name;
    }
}
