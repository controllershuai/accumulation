package com.yfs.accumulation.spring.aop.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.yfs.accumulation.spring.aop")
@EnableAspectJAutoProxy(proxyTargetClass=true,exposeProxy=true)
//@EnableAspectJAutoProxy(proxyTargetClass=true)
@Configurable
public class AopConfig {
    public AopConfig() {
        System.out.println("AopConfig created ...");
    }
}
