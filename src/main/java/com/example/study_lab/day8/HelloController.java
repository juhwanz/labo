package com.example.study_lab.day8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 디스패치서블렛은 스프링 부트가 켜질 때 자동 세팅 -> 인터셉터를 심어서 확인
@RestController
public class HelloController {

    @GetMapping("/day8")
    public String hello(){
        System.out.println("   >>> 3. [Controller] 실제 담당자가 업무 처리 중...");
        return "Day 8 Mission Complete";
    }

}
