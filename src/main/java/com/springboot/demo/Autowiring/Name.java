package com.springboot.demo.Autowiring;

import org.springframework.stereotype.Component;

@Component
public class Name {

    @Override
    public String toString() {
        String name = "XYZ";
        return "Name [is=" + name + "]";
    }
}