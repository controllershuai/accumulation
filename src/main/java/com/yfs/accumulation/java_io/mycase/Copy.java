package com.yfs.accumulation.java_io.mycase;

import java.io.*;

public class Copy {

    public static boolean fileExists(String path) {
        return new File(path).exists();
    }

    public static void createDir(String path) {
        File file = new File(path);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
    }

    public static void copy(String srcPath, String targetPath) {
        File inFile = new File(srcPath);
        File outFile = new File(targetPath);
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(inFile);
            output = new FileOutputStream(outFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            try {
                input.close();
                output.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        try {
            copyHandle(input, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyHandle(InputStream input, OutputStream output) throws IOException {
        //原始的，速度非常慢
        int temp = 0;
//        do {
//            temp = input.read();
//            output.write(temp);
//        } while (temp != -1);

        //每次读取批量和写出批量，加快速度
        byte data[] = new byte[2048];
        while ((temp = input.read(data)) != -1) {
            output.write(data, 0, temp);
        }
    }

}
