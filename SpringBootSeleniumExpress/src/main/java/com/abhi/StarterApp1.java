package com.abhi;

import com.abhi.properties.MyApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("abc.properties")
public class StarterApp1 {
    public static void main(String[] args) {

        ConfigurableApplicationContext container = SpringApplication.run(StarterApp1.class, args);

        System.out.println(container.getBean(MyApp.class).getAppName());
    }
}
