package com.example.study_lab.day8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 인터셉터 스프링에게 등록
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LogIntercepter logIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 모든 요청 인터셉터 적용
        registry.addInterceptor(logIntercepter)
                .addPathPatterns("/day8");
    }
}
