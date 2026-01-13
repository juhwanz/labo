package com.example.study_lab.day15;

// 검문소 규칙과 암호화 기계 등록

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Day15Config {

    // 비밀번호 암호화(BCrypt)
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                //1. CSRF (Cross-Site Request Forgery) : GET로만 테스트하면 괜찮지만, POST시 403 포비든 -> 실습에서는 끈다.
                .csrf(AbstractHttpConfigurer::disable)
                //2. H2 콘솔을 위한 헤더 설정 : 시큐리티 기본적으로 <iframe> 막음(클릭재킹 방지) -> 그래서 H2로그인 불가(풀어줘야함)
                .headers(headers -> headers.frameOptions(frame -> frame.disable()))

                //3. 권한 설정.
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/day15/public").permitAll()
                        .requestMatchers("/day15/private").authenticated()
                        .anyRequest().permitAll()
                )
                // 4. 로그인 폼.
                .formLogin(Customizer.withDefaults());

        return http.build();
    }
}
