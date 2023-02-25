package com.springboot.demo.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    String name;
    int age;
}
