package com.springboot.demo.AOP.ControllerAdvice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;

@SpringBootApplication(exclude = SqlInitializationAutoConfiguration.class)
@Slf4j
public class ControllerAdviceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControllerAdviceDemoApplication.class, args);
        System.out.println(":::::::::::::::::::::::::::::: Controller Advice Demo App Started on http://localhost:8081/ :::::::::::::::::::::::::::::::::::");

        SpringRestClient springRestClient = new SpringRestClient();

        springRestClient.createEmployee();

        springRestClient.getEmployees();

        springRestClient.updateEmployee();

        springRestClient.getEmployeeById();
    }

}
