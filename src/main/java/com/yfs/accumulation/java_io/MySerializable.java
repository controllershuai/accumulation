package com.yfs.accumulation.java_io;

import java.io.*;

public class MySerializable implements Serializable{

    private static File file = new File("D:"+ File.separator+"a.txt");
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        ois.readObject();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(new Object());

    }
}
