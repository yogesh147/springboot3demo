package com.springboot.demo.BeanWrapper;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.MutablePropertyValues;

public class BeanWrapperMutablePropertyExample {
    public static void main (String[] args) {
        BeanWrapper bw = new BeanWrapperImpl(new Person());
      //  MutablePropertyValues mpv = new MutablePropertyValues();
        MutablePropertyValues mpv = new MutablePropertyValues();
        mpv.add("name", "Diana");
        mpv.add("age", "30");

        bw.setPropertyValues(mpv);
        System.out.println(bw.getWrappedInstance());
    }
}
