package day1;

import day1.annotation.Message;

import java.lang.reflect.Field;

public class Main {

    @Message(msg = "你好世界.")
    public static String msg;
    @Message
    public static String msg0;
    @Message(msg = "你好世界.")
    public String msg1;
    @Message
    public String msg2;

    public static void main(String[] args) {
        Main main = new Main();
        Class clazz = main.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Message message = field.getAnnotation(Message.class);
            System.out.println(String.format("field=%s, msg=%s", field, message.msg()));
        }
    }
}
