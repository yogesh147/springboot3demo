package com.springboot.demo.BeanPostProcessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = SqlInitializationAutoConfiguration.class)
public class BeanPostProcessorDemoApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(BeanPostProcessorDemoApplication.class, args);
        System.out.println("::::::::::::::::::::::::::::::Bean Post Processor Demo App Started on http://localhost:8081/ :::::::::::::::::::::::::::::::::::");

        HelloWorld obj = (HelloWorld) applicationContext.getBean("helloWorld");
        obj.getMessage();
        applicationContext.close();
        applicationContext.registerShutdownHook();
    }

}