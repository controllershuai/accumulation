package com.yfs.accumulation.java_io;

import java.io.*;

public class MyPrintIO {
    //一般程序都用打印流，除非是二进制的
    //OutputStream的加强版
    //OutputStream的缺点，必须转换为字节数组，只支持字符串
    //PrintStream  PrintWriter
    //PrintWriter用的是装饰模式
    public static void main(String[] args) throws IOException {
        File file = new File("");
        OutputStream out = new FileOutputStream(file);
        PrintWriter writer = new PrintWriter(out);
        writer.print(123);
        //writer可以打印各种类型

        String name = "aaa";
        int age = 20;
        double salary = 10000.005;
        writer.printf("姓名：%s，年龄：%d，工资：%8.2f",name,age,salary);

        //String 也有格式化的方法
        String format = String.format("姓名：%s，年龄：%d，工资：%8.2f", name, age, salary);



    }


    public void systemTest() throws IOException {



    }
}
