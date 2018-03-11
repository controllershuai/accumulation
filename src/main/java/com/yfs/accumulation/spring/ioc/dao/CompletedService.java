package com.yfs.accumulation.spring.ioc.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompletedService {
    @Autowired
    private Map<String, AbstractDAO> allDaos;

    public Map<String, AbstractDAO> getAllDaos() {
        return allDaos;
    }

}
