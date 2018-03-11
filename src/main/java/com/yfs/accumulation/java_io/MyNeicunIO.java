package com.yfs.accumulation.java_io;

import java.io.*;

public class MyNeicunIO {
    /**
     * 输入输出不需要文件，只是通过内存
     * 字节内存流，字符内存流
     * 多文件合并用着很方便
     * @param args
     */
    public static void main(String[] args) throws IOException {
        InputStream input = new ByteArrayInputStream("afsdfasa".getBytes());
        OutputStream out = new ByteArrayOutputStream();
        int temp = 0;
        while ((temp = input.read()) != -1) {
            out.write(Character.toUpperCase(temp));
        }
        System.out.println(out);
    }

    public String getFileStr(File file) throws IOException {
        if (file.exists()) {
            InputStream input = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte data[] = new byte[1024];
            int temp = 0;
            while ((temp = input.read(data)) != -1) {
                bos.write(data, 0 ,temp);
            }
            return new String(bos.toByteArray());

        }
        return null;

    }



}
