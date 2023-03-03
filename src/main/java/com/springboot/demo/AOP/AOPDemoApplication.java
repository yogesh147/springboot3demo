package com.springboot.demo.AOP;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = SqlInitializationAutoConfiguration.class)
@Slf4j
public class AOPDemoApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(AOPDemoApplication.class, args);
        System.out.println(":::::::::::::::::::::::::::::: AOP Demo App Started on http://localhost:8081/ :::::::::::::::::::::::::::::::::::");

        Operation e = (Operation) applicationContext.getBean("operation");
        log.info("m1 Called");
        e.m1();
        log.info("m2 Called");
        e.m2();
        log.info("m3 Called");
        e.m3();
        log.info("m4 Called");
        e.m4();
        log.info("m5 Called");
        try {
            e.m5(10);
        } catch (Exception ignored) {
        }
    }

}
