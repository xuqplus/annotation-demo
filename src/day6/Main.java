package day6;

import day6.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class Main {

    @Autowired
    User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public void say() {
        System.out.println("hello, its me.");
    }

    public static void main(String[] args) throws InterruptedException {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(Main.class.getPackage().getName() + File.separator + "app.xml");
        context.start();
        Main main = context.getBean("main", Main.class);
        main.say();
        while (true) Thread.sleep(1006);
    }
}