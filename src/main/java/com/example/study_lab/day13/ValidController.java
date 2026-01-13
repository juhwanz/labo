package com.example.study_lab.day13;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidController {

    @PostMapping("/day13/members")
    public String saveMember(@Valid @RequestBody MemberSaveDto dto) {
        // 이 로그가 찍힌다는 건, 검증을 통과했다는 뜻!
        System.out.println(">>> [Controller] 저장 성공: " + dto.getName());
        return "저장 완료: " + dto.getName();
    }
}
