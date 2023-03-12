package com.springboot.demo.BeanPostProcessor;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class HelloWorld {

    public void getMessage() {
        String message = "ABC";
        System.out.println("Your Message : " + message);
    }

    @PostConstruct
    public void init() {
        System.out.println("Bean is going through init.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean will destroy now.");
    }
}
