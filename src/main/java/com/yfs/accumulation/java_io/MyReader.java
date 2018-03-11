package com.yfs.accumulation.java_io;

import java.io.*;

public class MyReader {
    public static void main(String[] args) throws IOException {
        File file = new File("path");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Reader reader = new FileReader(file);
        char data[] = new char[1024];
        int len = reader.read(data);
        System.out.println(new String(data,0,len));
        reader.close();
    }
}
