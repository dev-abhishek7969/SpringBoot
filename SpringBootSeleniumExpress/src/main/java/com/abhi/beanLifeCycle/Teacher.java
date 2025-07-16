package com.abhi.beanLifeCycle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Teacher implements InitializingBean {

    private List<String> subjectList;

    public Teacher(){
        System.out.println("Teacher is initializing !!");
    }

    //want this method to be called by the spring,whenever teacher object is created by the spring.
    @PostConstruct
    public void init(){
        System.out.println("Init invoked from post construct method .@PostConstruct");
        subjectList = new ArrayList<>();
        subjectList.add("Physics");
        subjectList.add("Maths");
    }

    public void teach(){
        System.out.println("Teaching started !!");
        for (String sub:subjectList) {
            System.out.println("Teaching "+sub);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("After properties set,after bean initialization .!!");
    }
}
