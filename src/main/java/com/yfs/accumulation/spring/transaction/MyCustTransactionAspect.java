package com.yfs.accumulation.spring.transaction;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

public class MyCustTransactionAspect extends TransactionAspectSupport implements DisposableBean {

    @Override
    public void destroy() throws Exception {
        clearTransactionManagerCache(); // An aspect is basically a singleton

    }

}
