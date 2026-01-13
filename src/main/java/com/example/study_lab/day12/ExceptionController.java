package com.example.study_lab.day12;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

@RestController
public class ExceptionController {

    @GetMapping("/day12/error")
    public String throwError() {
        // 일부러 예외 발생시킴
        throw new Day12Exception("폭탄 터짐!");
    }

    // [실험 2단계에서 주석 해제할 것]
    /*
    @ExceptionHandler(Day12Exception.class)
    public ResponseEntity<String> handleLocalException(Day12Exception e) {
        System.out.println(">>> [Local] 컨트롤러 내부 핸들러가 예외를 잡았습니다!");
        return ResponseEntity.status(400).body("[Local Error] 내가 먼저다!");
    }
    */
}
