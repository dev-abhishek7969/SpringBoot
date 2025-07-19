package com.abhi.beanLifeCycle.bean.post.processer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.*;

public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("Inside bean factory post process : BeanFactoryPostProcessor");

        String[] beanList = beanFactory.getBeanDefinitionNames();
        for (String name: beanList) {

//            System.out.println("Found bean with name =" +name);

            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
//            System.out.println("Bean Definition details........");

            if(beanDefinition.getBeanClassName().endsWith("Laptop")){
//                System.out.println("Going to change bean definition on demand");
                beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);
                beanDefinition.setInitMethodName("myInit");
            }
//            System.out.println(name+" bean properties are = "+ beanDefinition);

        }
    }
}
