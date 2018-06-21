package day1;

import day1.annotation.Message;

import java.lang.reflect.Field;

public class MainTests {
    public static void main(String... args) throws ClassNotFoundException, IllegalAccessException {
        Class clazz = Main.class.getClassLoader().loadClass("day1.Main");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Message message = field.getAnnotation(Message.class);
            System.out.println(String.format("field=%s, msg=%s", field, message.msg()));
        }
    }
}
