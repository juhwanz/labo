package com.example.study_lab.day2;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("singleton") 생략해도 됨
public class SingletonBean {

    // 이전
    //private final ProtoBean protoBean;

    // 핵심: ProtoBean을 직접 받는 게 아니라, "ProtoBean을 찾아주는 녀석(Provider)"을 받는다.
    private final ObjectProvider<ProtoBean> protoBeanProvider;

    public SingletonBean(ObjectProvider<ProtoBean> protoBeanProvider){
        this.protoBeanProvider = protoBeanProvider;
        System.out.println("Create SingletonBean -> Inject ProtoBean ");
    }

    public int logic() {
        // getObject()를 호출하는 시점에 스프링 컨테이너에서 "새로운 빈"을 꺼내온다 (DL)
        ProtoBean protoBean = protoBeanProvider.getObject();

        protoBean.addCount();
        return protoBean.getCount();
    }
}
