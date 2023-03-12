package com.springboot.demo.EventListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EventListenerDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(EventListenerDemoApplication.class, args);
        System.out.println(":::::::::::::::::::::::::::::: Event Listener Demo App Started on http://localhost:8081/ :::::::::::::::::::::::::::::::::::");
    }
}
