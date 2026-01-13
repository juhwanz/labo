package com.example.study_lab.day15;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Day15Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;        // 로그인 아이디
    private String password;        // 암호화된 비밀번호
    private String role;            // 권한

    public Day15Member(String username,String password, String role){
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
