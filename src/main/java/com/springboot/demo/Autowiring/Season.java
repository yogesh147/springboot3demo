package com.springboot.demo.Autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("season")
public class Season {
    @Autowired(required = false) // 4. By No Mode of Autowired
    private SeasonName name;

    @Override
    public String toString() {
        return "Season [name=" + name + "]";
    }

}
