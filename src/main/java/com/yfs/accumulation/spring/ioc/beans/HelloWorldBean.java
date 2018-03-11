package com.yfs.accumulation.spring.ioc.beans;

import java.util.Date;

public class HelloWorldBean {
    private String myName;
    public HelloWorldBean() {
        System.out.println(new Date()+" created "+ this);
    }

    public void hello() {
        System.out.println(new Date()+" hello "+myName+ " @ "+ this);
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }
}
