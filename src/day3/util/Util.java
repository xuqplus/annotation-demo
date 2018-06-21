package day3.util;

import day3.Main;

import java.io.File;

public class Util {
    public static String classpath() {
        return new File(Main.class.getClassLoader().getResource("").getPath()).getAbsolutePath();
    }

    public static void path() {
        System.out.println(new File("").getAbsolutePath());//工程源码根目录
        System.out.println(new File(Main.class.getClassLoader().getResource("").getPath()).getAbsolutePath());//classpath根目录

        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("java.class.path"));//jars
    }
}
