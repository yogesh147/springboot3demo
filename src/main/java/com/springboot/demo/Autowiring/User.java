package com.springboot.demo.Autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("user")
public class User {

    private final Name name;

    @Autowired // 2. By Constructor
    public User(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [name=" + name + "]";
    }
}