package com.springboot.demo.Autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("student")
public class Student {
    @Autowired // 2. On Field
    private RollNo number;

    @Override
    public String toString() {
        return "Student [rollNo=" + number + "]";
    }
}
