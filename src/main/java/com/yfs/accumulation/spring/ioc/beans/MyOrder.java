package com.yfs.accumulation.spring.ioc.beans;

import org.springframework.beans.factory.annotation.Configurable;

import javax.annotation.Resource;

@Configurable
public class MyOrder {
    @Resource
    private PropertyBean propertyBean;

    public PropertyBean getPropertyBean() {
        return propertyBean;
    }
}
