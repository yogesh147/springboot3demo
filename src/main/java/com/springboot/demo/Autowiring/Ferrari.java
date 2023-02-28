package com.springboot.demo.Autowiring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("Ferrari")
@Primary
public class Ferrari implements CarDetails {
    public void getName() {
        System.out.println("This is Ferrari");
    }
}
