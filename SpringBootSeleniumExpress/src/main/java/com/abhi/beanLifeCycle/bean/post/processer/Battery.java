package com.abhi.beanLifeCycle.bean.post.processer;

import org.springframework.stereotype.Component;

@Component
public class Battery {

    public void charging(){
        System.out.println("Charging");
    }
}
