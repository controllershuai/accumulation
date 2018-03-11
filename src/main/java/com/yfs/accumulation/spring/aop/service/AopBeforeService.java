package com.yfs.accumulation.spring.aop.service;

import org.springframework.stereotype.Component;

@Component
public class AopBeforeService {
    public void m1(){
        System.out.println("AopBeforeService  m1  ...");
    }
}
