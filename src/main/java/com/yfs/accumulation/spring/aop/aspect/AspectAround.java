package com.yfs.accumulation.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectAround {
    public AspectAround() {
        System.out.println("AspectAround created ...");
    }
    @Around("execution(* com.yfs.accumulation.spring.aop.service.AopAroundService.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("AspectAround  around  in");
        jp.proceed(jp.getArgs());
        System.out.println("AspectAround  around  out");
    }
}
