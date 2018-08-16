package day9;

import day9.domain.User;
import day9.util.Util;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class Main {

    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(Main.class.getPackage().getName() + File.separator + "app.xml");
        context.start();
        User user0 = context.getBean(User.class);
        User user1 = new User();
        List<String> columns = new ArrayList<String>() {{
            add("0");
            add("1");
            add("2");
            add("3");
            add("4");
        }};
        while (true) {
            Object o = Util.get(user0);
            Util.set(user1, columns);
            Thread.sleep(1000L);
        }
    }
}