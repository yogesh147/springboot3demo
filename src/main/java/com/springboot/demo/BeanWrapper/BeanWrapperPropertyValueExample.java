package com.springboot.demo.BeanWrapper;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;

public class BeanWrapperPropertyValueExample {
    public static void main (String[] args) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(new Person());
        PropertyValue pv = new PropertyValue("name", "John");
        beanWrapper.setPropertyValue("name", "John");
        PropertyValue pv2 = new PropertyValue("age", 33);
        beanWrapper.setPropertyValue(pv);
        beanWrapper.setPropertyValue(pv2);
        System.out.println("bean: "+beanWrapper.getWrappedInstance());
    }
}
