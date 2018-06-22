package day7.util;

import day7.Main;

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

    public static String uppperFirst(String str) {
        if (Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        String a = str.substring(0, 1);
        return a.toUpperCase() + str.substring(1);
    }
}
