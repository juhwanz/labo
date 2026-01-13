package com.example.study_lab.day15;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Security가 "야, 이 아이디 누구냐?"고 물어보면 DB에서 물어다 주는 역.
@Service
@RequiredArgsConstructor
public class Day15UserDetailsService implements UserDetailsService {

    private final Day15Repository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        // 1. DB 조회
        Day15Member member = repository.findByUsername(username)
                .orElseThrow( () -> new UsernameNotFoundException("유저 없음 : " + username ));

        // 2. 시큐리티 전용 명함(UserDetails)로 바꿔서 제출
        return User.builder()
                .username(member.getUsername())
                .password(member.getPassword())
                .roles(member.getRole())
                .build();
    }
}
