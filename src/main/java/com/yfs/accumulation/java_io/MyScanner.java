package com.yfs.accumulation.java_io;

import java.util.Scanner;
//扫描流，一般读取都用这个，除非是处理二进制的文件
public class MyScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入:");
        if (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        if (scanner.hasNextInt()) {
            System.out.println(scanner.nextInt());
        }
        if (scanner.hasNext("正则表达式")) {
            System.out.println(scanner.next());
        }

    }
}
