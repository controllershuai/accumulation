package com.yfs.accumulation.java_io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class MyWriter {
    public static void main(String[] args) throws IOException {
        File file = new File("");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        String msg = "afsdfasdfas";
        Writer writer = new FileWriter(file);
        writer.write(msg);
        //可能在缓存中，需要缓存清空
        writer.flush();
        writer.close();
    }
}
