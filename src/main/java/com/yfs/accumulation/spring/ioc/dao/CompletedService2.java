package com.yfs.accumulation.spring.ioc.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompletedService2 {

    @Autowired
    private Collection<AbstractDAO> allDaos;

    public Collection<AbstractDAO> getAllDaos() {
        return allDaos;
    }
}
