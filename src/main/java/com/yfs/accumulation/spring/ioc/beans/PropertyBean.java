package com.yfs.accumulation.spring.ioc.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;
@Component
@Scope("prototype")
public class PropertyBean {
    @Value("${system.appname}")
    private String myName;

    @PostConstruct
    public void init() {
        System.out.println("PropertyBean.init");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("PropertyBean.init");
    }

    public PropertyBean() {
        System.out.println(new Date() + " created " + this);
    }

    public void hello() {
        System.out.println(new Date() + " hello " + myName + " @ " + this);

    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }
}
