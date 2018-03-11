package com.yfs.accumulation.java_io;

import java.io.*;

public class BufferedStream {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入信息：");
        System.out.println("输入的信息是：" + reader.readLine());
    }
}
