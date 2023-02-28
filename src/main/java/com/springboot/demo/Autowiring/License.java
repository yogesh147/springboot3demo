package com.springboot.demo.Autowiring;

import org.springframework.stereotype.Component;

@Component
public class License {

    @Override
    public String toString() {
        String number = "123456ABC";
        return "License [number=" + number + "]";
    }
}