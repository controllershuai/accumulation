package com.yfs.accumulation.java_io;

import com.sun.javafx.binding.StringFormatter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class MySystemIO {
    public static void main(String[] args) throws IOException {
        PrintStream out1 = System.out;
        out1.println(1212);
        //等价于 System.out.println();

        InputStream in = System.in;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] data = new byte[10];
        System.out.println("输入信息：");
        int temp = 0;
        StringBuffer buffer = new StringBuffer();
        while ((temp = in.read())!=-1) {
            if (temp == '\n') {
                break;
            }
            buffer.append((char) temp);
        }

//        while ((temp = in.read(data))!=-1) {
//            bos.write(data,0,temp);
//            if (temp < data.length){
//                break;
//            }
//        }
        String str = new String(bos.toByteArray());
        System.out.println("你输入的信息是："+str);
        System.out.println("你输入的信息是："+buffer);
    }
}
