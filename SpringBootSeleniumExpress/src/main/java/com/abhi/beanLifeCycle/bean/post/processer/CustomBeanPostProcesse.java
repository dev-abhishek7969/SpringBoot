package com.abhi.beanLifeCycle.bean.post.processer;

import org.springframework.beans.factory.config.BeanPostProcessor;


//After bean are created and you want to do something we can use
public class CustomBeanPostProcesse implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean,String beanName){

        System.out.println("inside postProcessBeforeInitialization --- postProcessBeforeInitialization");

        return  bean;
    }

}
