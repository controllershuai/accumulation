package com.yfs.accumulation.spring.transaction;

public class MyCustTXException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MyCustTXException(String mesg) {
        super(mesg);
    }
}