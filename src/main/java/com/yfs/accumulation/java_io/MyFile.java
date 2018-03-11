package com.yfs.accumulation.java_io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFile {
    /**
     * Fil是唯一一个与文件本身操作（创建、删除，获取信息等）有关的类
     * 使用的时候直接创建实例化对象即可
     *
     *File(File parent, String child) 设置父路径和子文件
     *
     *boolean createNewFile()  file只负责创建文件，对内容不负责
     *
     * java的文件操作需要操作系统的支持，如果操作同名文件，有可能出现延迟问题。如果需要的话就在操作只有加一个Thread.sleep(xxx)
     *
     *
     */

    public static void main(String[] args) throws IOException {
        //这个路径必须是系统的路径，比如d:\a.txt但是d:\a\a.txt就不行
        File file = new File("d:\\a\\hello.txt");
        File file1 = new File("d:\\hello.txt");
        System.out.println(file.getParentFile());
        //创建目录
        if (!file.getParentFile().exists()) {
            //支持多级目录
            file.getParentFile().mkdirs();
            //只支持以及目录
            file.getParentFile().mkdir();
        }
        file.createNewFile();
        if (file.exists()) {
            file.delete();
        }
        String s = File.separator; //不同系统不同的 斜杠

        file.isFile();//是否是文件
        file.isDirectory();//是否是目录
        if (file.exists() && file.isFile()) {
            //区的文件大小
            long length = file.length();
            //转换成兆为单位
            double d = file.length() / (double) 1024 / 1024;
            //最后修改日期的时间戳
            long l = file.lastModified();
            file.canExecute();
            file.canRead();
            file.canWrite();
        }

        if (file.exists() && file.isDirectory()) {
            //本目录的第一级的文件信息
            File[] files = file.listFiles();
            for (File file2 : files) {
                System.out.println(file2.getName());
            }

        }

    }

    /**
     * 线程阻塞问题，这个操作会很慢,让主线程阻塞，可以用新线程处理
     * @param file
     * @return
     */
    //通过递归获取文件目录下的所有文件
    public static List<File> getFiles(File file){
        List<File> files = new ArrayList<>();
        if (file.exists() && file.isFile()) {
            files.add(file);
        }
        if (file.exists() && file.isDirectory()) {
            File[] childFiles = file.listFiles();
            for (File childFile : childFiles) {
                files.addAll(getFiles(childFile));
            }
        }
        return files;
    }
}
