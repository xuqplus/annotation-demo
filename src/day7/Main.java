package day7;

import day7.service.Run;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(Main.class.getPackage().getName() + File.separator + "app.xml");
        context.start();
        Run run = context.getBean(Run.class);
        while (true) {
            Thread.sleep(1007);
            run.say();
            System.out.println(run.getMsg());
            System.out.println(run.getMsg1());
            System.out.println(run.getUser());
        }
    }
}