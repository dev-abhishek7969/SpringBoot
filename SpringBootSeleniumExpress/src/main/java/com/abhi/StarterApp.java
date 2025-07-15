package com.abhi;

import com.abhi.runmethod.College;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class StarterApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(StarterApp.class);
        ConfigurableApplicationContext container = app.run();

        System.out.println("*****************************");
        College college = container.getBean(College.class);
        college.printCollege();
    }
}
