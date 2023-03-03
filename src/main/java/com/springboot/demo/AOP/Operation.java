package com.springboot.demo.AOP;

import org.springframework.stereotype.Component;

@Component("operation")
public class Operation {

    public void m1() {
        System.out.println("m1 method invoked");
    }

    public int m2() {
        System.out.println("m2 method invoked");
        int a = 1;
        int b = 2;
        System.out.println("m2 method invoked with b" + b);
        return a + b;
    }

    public int m3() {
        System.out.println("m3 method invoked");
        return 3;
    }

    public int m4() {
        System.out.println("m4 method invoked");
        return 4;
    }

    public void m5(int age) {
        if (age < 18) throw new ArithmeticException("Not valid age");
        System.out.println("Thanks for vote");
    }

    @LogExecutionTime
    public void customAdviceAnnotation() throws InterruptedException {
        Thread.sleep(2000);
    }

}
