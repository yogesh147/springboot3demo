package com.springboot.demo.AOP;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component("student")
@Data
public class Student {
    private Integer age;
}
