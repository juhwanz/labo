package com.example.study_lab.day15;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 실험용 컨트롤러
@RestController
@RequestMapping("/day15")
public class SecurityController {

    // [public] 아무나 환영
    @GetMapping("/public")
    public String publicPage(){
        return ">>> [Public] 여기는 누구나 들어옵니다. (검사X)";
    }

    //[Private] 여권 필요
    @GetMapping("/private")
    public String privatePage(Authentication auth){
        return ">>> [Private] 인증된 사람만 접근 가능 (로그인 성공)" + auth.getName();
    }
}
