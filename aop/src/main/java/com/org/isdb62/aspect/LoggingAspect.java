package com.org.isdb62.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(*com.org.isdb62.service.*.*(..))")
    public  void beforeMethodCall(JoinPoint joinPoint){
        System.out.println("🚀 BEFORE: Method called - "+ joinPoint.getSignature());
    }

    @Around("execution(*com.org.isdb62.service.*.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("🔁 AROUND: Before method - " + joinPoint.getSignature());
        Object result = joinPoint.proceed();
        System.out.println("✅ AROUND: After method - " + joinPoint.getSignature());
        return result;
    }
}
