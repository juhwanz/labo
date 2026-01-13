package com.example.study_lab.day11;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AutoConfigRunner implements CommandLineRunner {

    private final ApplicationContext ac;

    public AutoConfigRunner(ApplicationContext ac){
        this.ac = ac;
    }

    @Override
    public void run(String... args) throws Exception{
        System.out.println("========== [Day 11] AutoConfiguration 실험 ==========");

        boolean hasMagicBean = ac.containsBean("magicBean");

        if (hasMagicBean) {
            System.out.println(">>> 성공: " + ac.getBean("magicBean"));
        } else {
            System.out.println(">>> 실패: magicBean이 등록되지 않았습니다. (조건 불만족)");
        }

        System.out.println("=====================================================");
    }
}
