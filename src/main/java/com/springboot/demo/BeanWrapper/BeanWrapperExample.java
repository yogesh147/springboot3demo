package com.springboot.demo.BeanWrapper;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class BeanWrapperExample {
    public static void main (String[] args) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(new Person());
        beanWrapper.setPropertyValue("name", "John");
        beanWrapper.setPropertyValue("age", 33);
        //the next commented line will also work, auto conversion is performed by Spring
        /*   beanWrapper.setPropertyValue("age", "33");*/

        System.out.println("bean: "+beanWrapper.getWrappedInstance());
        //getting property value
        Object value = beanWrapper.getPropertyValue("name");
        System.out.println("person.name: "+value);
    }
}
