package com.example.study_lab.day8;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// 디스패치 서블렛이 컨트롤러 부르기 직전(preHandle)와 직후(postHandle)에 끼어듬.
@Component
public class LogIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object hander){
        System.out.println(">>> 1. [DispatcherServlet] -> [Interceptor]: 컨트롤러 부르러 가는 중입니다.");
        System.out.println("    (요청 주소: " + request.getRequestURI() + ")");
        return true; // true-> 컨틀롤러로 진행, false면 차단.
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object hander, ModelAndView modelAndView){
        System.out.println(">>> 4. [Interceptor] -> [DispatcherServlet]: 컨트롤러가 일 다 마치고 복귀했습니다.");
    }

}
