package com.springboot.demo.Autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    @Autowired // 3. By Type
  //  @Qualifier("Mustang")
    private CarDetails carDetails;

    public void getDetails() {
        carDetails.getName();
    }
}

