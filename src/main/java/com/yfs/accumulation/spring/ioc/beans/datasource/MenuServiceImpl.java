package com.yfs.accumulation.spring.ioc.beans.datasource;

public class MenuServiceImpl implements MenuService {
    @Override
    public String[] getMenus(String userRole) {
        return new String[] { "login", "try", "exit" };
    }
}
