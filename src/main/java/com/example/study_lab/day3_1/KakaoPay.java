package com.example.study_lab.day3_1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// 3. 구현체 B (카카오페이)
@Component
@Primary
public class KakaoPay implements Payment {
    @Override
    public String pay() { return "카카오페이 결제"; }
}
