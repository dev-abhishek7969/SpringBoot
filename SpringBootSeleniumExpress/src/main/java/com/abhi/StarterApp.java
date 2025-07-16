package com.abhi;

import com.abhi.runmethod.College;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration //one or more beans are present here @SpringBootConfiguration
//@ComponentScan //scan for components
//@EnableAutoConfiguration //setup web application server for us

@SpringBootApplication
public class StarterApp {
    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(StarterApp.class);
        ConfigurableApplicationContext container = app.run();

        //other implementation of run method.
        //SpringApplication.run(StarterApp.class,args);


        System.out.println("*****************************");
        College college = container.getBean(College.class);
        college.printCollege();
    }

    @Bean
    public College collegeObj(){
        return  new College();
    }
}
