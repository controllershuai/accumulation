package com.yfs.accumulation.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class AspectBefore {
    public AspectBefore() {
        System.out.println("AspectBefore created ...");
    }

    @Before("execution(* com.yfs.accumulation.spring.aop.service.*.*(..))")
    public void before1() {
        System.out.println("AspectBefore before1 ...");
    }

    @Before("execution(* com.yfs.accumulation.spring.aop.service.*.*(..))")
    public void before2(JoinPoint jp) {
        System.out.println("AspectBefore before2 ...");
        System.out.println("joinpoint: " + jp.getKind());
        System.out.println("declaringTypeName: " + jp.getSignature().getDeclaringTypeName());
        System.out.println("this: " + jp.getThis().getClass().getName());
        System.out.println("args: " + Arrays.toString(jp.getArgs()));
    }
}
