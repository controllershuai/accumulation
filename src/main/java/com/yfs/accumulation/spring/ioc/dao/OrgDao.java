package com.yfs.accumulation.spring.ioc.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Lazy
@Order(100)
@Component("orgDao")
public class OrgDao implements AbstractDAO<String> {
    public OrgDao() {
        System.out.println(this + " order " + 100);
    }
}
