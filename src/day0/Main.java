package day0;

import day0.annotation.Message;

@Message(msg = "你好世界.")
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Class clazz = main.getClass();
        Message message = (Message) clazz.getAnnotation(Message.class);
        System.out.println(message.msg());
    }
}
