package com.springboot.demo.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("aspectDemo")
@Aspect
public class AspectDemo {
    @Pointcut("execution(* Operation.m1(..))")
    public void beforeAdvice() {
    }

    @Before("beforeAdvice()")
    public void beforeAdvice(JoinPoint jp) {
        System.out.println("beforeAdvice Method Signature : " + jp.getSignature().getName());
    }

    @Pointcut("execution(* Operation.m3(..))")
    public void afterAdvice() {
    }
    @After("afterAdvice()")
    public void afterAdvice(JoinPoint jp) {
        System.out.println("afterAdvice Method Signature : " + jp.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* Operation.m2(..))", returning = "result")
    public void myadvice(JoinPoint jp, Object result) {
        System.out.println("additional concern");
        System.out.println("Method Signature: " + jp.getSignature());
        System.out.println("Result in advice: " + result);
        System.out.println("end of after returning advice...");
    }

    @Pointcut("execution(* Operation.m4(..))")
    public void AroundAdvice(){}

    @Around("AroundAdvice()")
    public Object AroundAdvice(ProceedingJoinPoint pjp) throws Throwable
    {
        System.out.println("Additional Concern Before calling actual method :: " + pjp.getSignature().getName());
        Object obj=pjp.proceed();
        System.out.println("Additional Concern After calling actual method :: " + pjp.getSignature().getName());
        return obj;
    }

    @AfterThrowing(pointcut = "execution(* Operation.m5(..))",throwing= "error")
    public void afterThrowing(JoinPoint jp,Throwable error)
    {
        System.out.println("additional concern");
        System.out.println("Method Signature: "  + jp.getSignature().getName());
        System.out.println("Exception is: "+error);
        System.out.println("end of after throwing advice...");
    }
}
