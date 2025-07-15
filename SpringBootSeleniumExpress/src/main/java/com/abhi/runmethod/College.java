package com.abhi.runmethod;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class College {

    public void printCollege(){
        System.out.println("College name is IIT");
    }
}
