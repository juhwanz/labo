package com.example.study_lab.day3_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final Payment payment;

    // 생성자 주입
    // 에러 터짐 - 선택 장애
    @Autowired
    public OrderService(@Qualifier("naverPay") Payment payment){
        this.payment = payment;
    }

    public void process(){
        System.out.println(payment.pay());
    }
}
