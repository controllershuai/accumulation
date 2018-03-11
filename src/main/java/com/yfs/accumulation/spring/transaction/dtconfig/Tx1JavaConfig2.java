package com.yfs.accumulation.spring.transaction.dtconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.yfs.accumulation.spring.transaction")
@EnableTransactionManagement
public class Tx1JavaConfig2 {

    @Bean
    public PlatformTransactionManager getTransactionManager() {
        System.out.println("transaction Manager created ");
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(getDataSource());
        return txManager;
    }

    @Bean
    public DriverManagerDataSource getDataSource() {
        System.out.println("datasource created  ");
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/leaderdb?serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }

}
