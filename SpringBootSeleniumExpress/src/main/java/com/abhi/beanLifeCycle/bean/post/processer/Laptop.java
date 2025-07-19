package com.abhi.beanLifeCycle.bean.post.processer;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Laptop implements InitializingBean {

    private Battery battery;

    public void myInit(){
        System.out.println("Inside init method");
    }

    public  Laptop(){
        System.out.println("********* Laptop is initialized");
    }

    public void chargeLaptop(){
        battery.charging();
    }

    @Autowired
    public void setBattery(Battery battery) {
        this.battery = battery;
        System.out.println("Setting properties.");
    }

    @PostConstruct
    public void runAtStart(){
        System.out.println("Post construct.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("After property set.");
    }
}
