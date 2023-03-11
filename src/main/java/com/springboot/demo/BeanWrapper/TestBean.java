package com.springboot.demo.BeanWrapper;

import lombok.Data;

import java.util.Date;

@Data
public class TestBean {
    private String aString;
    private int anInt = 5;
    private Date date = new Date(12000000000L);
}
