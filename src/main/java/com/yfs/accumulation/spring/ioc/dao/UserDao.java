package com.yfs.accumulation.spring.ioc.dao;

import com.yfs.accumulation.spring.ioc.beans.HelloWorldBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Lazy
@Order(10)
@Component("userDao")
public class UserDao implements AbstractDAO<HelloWorldBean> {
    public UserDao() {
        System.out.println(this + " order " + 10);
    }
}
