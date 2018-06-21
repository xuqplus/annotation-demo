package day2;

import day2.annotation.Message;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    @Message
    String msg(String msg) {
        return msg;
    }

    @Message(msg = "你好世界.")
    String msg1(String msg) {
        return msg;
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class clazz = Main.class.getClassLoader().loadClass("day2.Main");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Message.class)) {
                Message message = method.getAnnotation(Message.class);
                System.out.println(String.format("method=%s, msg=%s", method, message.msg()));
                System.out.println(String.format("反射执行方法-->%s", method.invoke(clazz.newInstance(), message.msg())));
            }
        }
    }
}