package com.springboot.demo.BeanWrapper;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

public class PropertyAccessorFactoryExample {

    public static void main (String[] args) {
        BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(new Person());
        bw.setPropertyValue("name", "Raj");
        bw.setPropertyValue("age", "26");
        System.out.println(bw.getWrappedInstance());
    }
}
