package com.springboot.demo.mocky;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getWelcomeMessage() {
        return "Hello World!";
    }

}