package day4;

import day4.annotation.Message;
import day4.domain.User;
import day4.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

@Component
public class Main {

    @Autowired
    User user;

    void say() {
        System.out.println("hello, its me.");
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, InterruptedException {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(Main.class.getPackage().getName() + File.separator + "app.xml");
        context.start();
        Main main = context.getBean(Main.class);
        main.say();
        while (true) Thread.sleep(1000);
    }
}