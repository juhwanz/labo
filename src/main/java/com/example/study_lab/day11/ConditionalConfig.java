package com.example.study_lab.day11;
// 조건부 빈 만들기. " 프로젝스 속성 파일에 custom.feature.enabled = true 라고 명시 시 빈 등록.

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalConfig {

    @Bean
    @ConditionalOnProperty(name = "custom.feature.enabled", havingValue = "true")
    public String magicBean(){
        return " 조건이 맞을 때 생성되는 빈.";
    }
}
