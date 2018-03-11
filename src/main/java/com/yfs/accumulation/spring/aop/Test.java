package com.yfs.accumulation.spring.aop;

import com.yfs.accumulation.spring.aop.config.AopConfig;
import com.yfs.accumulation.spring.aop.service.AopAroundService;
import com.yfs.accumulation.spring.aop.service.AopBeforeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) throws Exception {
        aspectBeforeTest();
        aspectAroundTest();
    }

    public static void aspectBeforeTest() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
        AopBeforeService beforeService = ctx.getBean(AopBeforeService.class);
        beforeService.m1();
        ctx.close();
    }

    public static void aspectAroundTest() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
        AopAroundService aroundService = ctx.getBean(AopAroundService.class);
        aroundService.m1();
        ctx.close();
    }
}
