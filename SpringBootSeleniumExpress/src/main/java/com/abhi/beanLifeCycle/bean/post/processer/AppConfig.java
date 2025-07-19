package com.abhi.beanLifeCycle.bean.post.processer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public static CustomBeanFactoryPostProcessor beanFactoryPostProcessor(){
        return  new CustomBeanFactoryPostProcessor();
    }

    @Bean static  CustomBeanPostProcesse customBeanPostProcesse(){
        return new CustomBeanPostProcesse();
    }
}
