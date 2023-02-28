package com.springboot.demo.Autowiring;

import org.springframework.stereotype.Component;

@Component("Mustang")
public class Mustang implements CarDetails {

    public void getName() {
        System.out.println("This is Mustang");
    }
}
