package com.yfs.accumulation.java_io;

public class MyCode {
    /**
     * GBK 中文
     * GB2312 简体中文
     * UNICODE  java提供的 十六进制编码
     * ISO8859-1 国际通用编码
     * UTF-8  结合了UNICODE和ISO8859-1
     * 乱码的问题是编码和解码的不统一造成的
     */

    public static void main(String[] args) {
        System.getProperties().list(System.out);
    }
}
