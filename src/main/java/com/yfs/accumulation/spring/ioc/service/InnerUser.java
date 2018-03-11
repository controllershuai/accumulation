package com.yfs.accumulation.spring.ioc.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class InnerUser {
    public void add() {
        System.out.println("add");
    }
}
