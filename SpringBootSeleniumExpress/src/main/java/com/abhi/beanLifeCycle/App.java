package com.abhi.beanLifeCycle;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
         AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
         container.getBean(Teacher.class).teach();
    }
}
