package com.springboot.demo.Autowiring;

import org.springframework.stereotype.Component;

@Component
public class RollNo {

    @Override
    public String toString() {
        String rollNumber = "123789";
        return "Roll [number=" + rollNumber + "]";
    }
}
