package com.yfs.accumulation.spring.ioc.beans.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Profile(value = "free_version")
@Configuration
@PropertySource(value = "classpath:config4freeversion.properties")
public class Config4FreeVersion {
    public Config4FreeVersion() {
        System.out.println("@Configuration ConfigForFreeVersion created ");
    }
    @Autowired
    Environment env;
    @Bean
    DataSourceBean dataSourceBean() {
        DataSourceBean dataSourceBean = new DataSourceBean();
        dataSourceBean.setUrl(env.getProperty("url"));
        dataSourceBean.setUser(env.getProperty("user"));
        dataSourceBean.setPassword(env.getProperty("pwd"));
        System.out.println("get store file path:" + env.getProperty("system.storefile"));
        return dataSourceBean;
    }
    @Bean
    MenuService menuService(){
        MenuService menuService = new MenuServiceImpl();
        return menuService;
    }
}
