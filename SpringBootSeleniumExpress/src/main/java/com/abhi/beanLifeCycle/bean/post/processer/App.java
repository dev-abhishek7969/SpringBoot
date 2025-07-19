package com.abhi.beanLifeCycle.bean.post.processer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("**************** Calling the API method begin *******************");
        Laptop lap = container.getBean(Laptop.class);
        lap.chargeLaptop();
        System.out.println("**************** Calling the API method end *******************");
    }

}
