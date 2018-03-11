package com.yfs.accumulation.spring.aop.service;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

@Component
public class AopAroundService {

    public void m1() throws Exception {
        System.out.println("AopAroundService  m1 in");
//        if (true) {
//            throw new Exception("aaa");
//        }
        Object proxy = AopContext.currentProxy();
        ((AopAroundService) proxy).m2();
        Advised advised = (Advised) proxy;
        System.out.println(advised.getTargetSource());
        System.out.println(advised.getTargetSource().isStatic());
        this.m2();
    }

    public void m2() {
        System.out.println("AopAroundService  m2");
    }
}
