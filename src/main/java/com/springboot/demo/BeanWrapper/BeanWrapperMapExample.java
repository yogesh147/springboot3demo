package com.springboot.demo.BeanWrapper;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashMap;
import java.util.Map;

public class BeanWrapperMapExample {
    public static void main (String[] args) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(new Person());
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Tina");
        map.put("age", "32");
        beanWrapper.setPropertyValues(map);
        System.out.println(beanWrapper.getWrappedInstance());
    }
}
