package com.example.study_lab.day3_1;

import org.springframework.stereotype.Component;

// 2. 구현체 A (네이버페이)
@Component
public class NaverPay implements Payment {
    @Override
    public String pay() { return "네이버페이 결제"; }
}
