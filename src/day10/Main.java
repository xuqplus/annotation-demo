package day10;

import day10.domain.User;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Component
public class Main {

    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(Main.class.getPackage().getName() + File.separator + "app.xml");
        context.start();
        testReflect(); // 反射
    }

    public static void testReflect() {
        User user = new User();
        Field[] fields = User.class.getFields(); // 所有public的, 包括继承的
        Field[] declaredFields = User.class.getDeclaredFields(); // 所有内部定义的
        Method[] methods = User.class.getMethods(); // 所有public的, 包括继承的
        Method[] declaredMethods = User.class.getDeclaredMethods(); // 所有内部定义的
        Annotation[] annotations = User.class.getAnnotations();
        Annotation[] declaredAnnotations = User.class.getDeclaredAnnotations();
    }
}