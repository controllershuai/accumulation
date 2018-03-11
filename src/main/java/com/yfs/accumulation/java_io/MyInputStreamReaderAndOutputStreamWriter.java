package com.yfs.accumulation.java_io;

import java.io.*;

public class MyInputStreamReaderAndOutputStreamWriter {
    public static void main(String[] args) throws IOException {
        File file = new File("");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        //字节流和字符流的转换
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(inputStream);

        OutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
    }
}
