package com.springboot.demo.WebAwareScopes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;

@SpringBootApplication(exclude = SqlInitializationAutoConfiguration.class)
public class WebAwareScopeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebAwareScopeDemoApplication.class, args);
        System.out.println("::::::::::::::::::::::::::::::Web Aware Scope Demo App Started on http://localhost:8081/ :::::::::::::::::::::::::::::::::::");
    }

}
