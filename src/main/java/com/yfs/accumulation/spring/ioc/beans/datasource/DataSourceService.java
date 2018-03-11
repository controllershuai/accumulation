package com.yfs.accumulation.spring.ioc.beans.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataSourceService {
    @Autowired
    public DataSourceBean dataSourceBean;
    public DataSourceBean getDataSourceBean() {
        return dataSourceBean;
    }
}
