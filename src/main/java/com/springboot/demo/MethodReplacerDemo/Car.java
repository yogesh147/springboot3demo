package com.springboot.demo.MethodReplacerDemo;

public class Car {

    public static void design() {
        System.out.println("Old car design.");
    }

    public static String breaks() {
        System.out.println("Old car break.");
        return "Old car Break.";
    }
}
