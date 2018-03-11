package com.yfs.accumulation.java_io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 字节输出流
 */
public class MyOutpuStream {

//    public static void main(String[] args) throws IOException {
//        File file = new File("d:" + File.separator + "a.txt");
//        if (!file.getParentFile().exists()) {
//            file.getParentFile().mkdirs();
//        }
//
//        //文件不需要file.createNewFile();  因为输出流会自动创建 ，每次执行都是覆盖
//        OutputStream outputStream = new FileOutputStream(file);
//        String msg = "yfs";
//        outputStream.write(msg.getBytes());
//        outputStream.close();
//
//        //这个是追加信息
//        OutputStream outputStream1 = new FileOutputStream(file, true);
//        outputStream1.write("xxxxxx".getBytes());
//        outputStream1.close();
//
//    }

    public static void main(String[] args) {
        //自动关闭需要try 的支持    实现AutoCloseable接口的类需要在try里面定义
        try (Message msg = new Message()) {
            msg.print();
        } catch (Exception e) {

        }
    }
}

class Message implements AutoCloseable {
    public Message() {
        System.out.println("create ");
    }

    public void print(){
        System.out.println("...");
    }

    @Override
    public void close() throws Exception {
        System.out.println("close ...");
    }
}
