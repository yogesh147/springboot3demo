package com.springboot.demo.Common;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringContainer {
    public static BeanFactory getBeanFactory() {
        return new AnnotationConfigApplicationContext(ApplicationBeans.class);
    }
}
