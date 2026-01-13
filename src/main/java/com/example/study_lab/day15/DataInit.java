package com.example.study_lab.day15;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

// 서버 켤 떄, 테스트 계정(testUser/ 1234)을 자동으로 생성
@Component
@RequiredArgsConstructor
public class DataInit {

    private final Day15Repository repository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init(){
        // 이미 있으면 생성 X
        if(repository.findByUsername("testUser").isPresent()){
            return;
        }

        String encodedPwd = passwordEncoder.encode("1234");
        Day15Member member = new Day15Member("testUser", encodedPwd, "USER");

        repository.save(member);
        System.out.println(">>> [Day15] 테스트 계정 생성 완료 (ID: testUser / PW: 1234)");
    }
}
