package com.yfs.accumulation.spring.ioc.dao;

public interface AbstractDAO<T> {

    // private SessionFactory;
    public default boolean createDomainObj(T domainObj) {
        return true;
    }

    default boolean deleteDomainObj(Integer objId) {
        return true;
    }

}
