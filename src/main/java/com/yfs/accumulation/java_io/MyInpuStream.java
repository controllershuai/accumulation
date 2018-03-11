package com.yfs.accumulation.java_io;


import java.io.*;

public class MyInpuStream {
    public static void main(String[] args) throws IOException {
        File file = new File("xxxx");
        if (file.exists() && file.isFile()) {
            InputStream inputStream = new FileInputStream(file);
            //定义每次读取的最大数量
            byte data[] = new byte[1024];
            int read = inputStream.read(data);
            OutputStream outputStream = new FileOutputStream(file);
            //读取的内容
            String string = new String(data, 0, read);
            inputStream.close();
        }


    }
}
