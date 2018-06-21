package day3;

import day3.annotation.Message;
import day3.domain.User;
import day3.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

@Component
public class Main {

    @Message
    String msg;

    @Message(msg = "你好世界.")
    String msg1;

    @Autowired
    User user;

    static String path = Util.classpath();

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, InterruptedException {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(Main.class.getPackage().getName() + File.separator + "app.xml");
        context.registerShutdownHook();
        Main main = context.getBean(Main.class);
        System.out.println(main);
        while (true) Thread.sleep(1000);
    }
}