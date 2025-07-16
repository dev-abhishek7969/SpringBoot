package com.abhi.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyApp1 {


    @Value("${myapp.name}")
    private String testPro;

    public String getTestPro() {
        return testPro;
    }

    public void setTestPro(String testPro) {
        this.testPro = testPro;
    }
}
