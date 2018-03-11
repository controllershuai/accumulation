package com.yfs.accumulation.spring.ioc.service;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component("annotationBean")
public class AnnotationBean {
    private String myName;

    public AnnotationBean() {
        System.out.println(new Date() + " created " + this);
    }

    public void hello() {
        System.out.println(new Date() + " hellow " + myName + " @ " + this);

    }

    public void setMyName(String myName) {
        this.myName = myName;
    }
}
