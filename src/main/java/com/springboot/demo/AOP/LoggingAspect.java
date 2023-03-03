package com.springboot.demo.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* Student.getAge(..))")
    public void beforeAdvice(JoinPoint jp) {
        System.out.println("Going to setup student profile.");
    }

}
