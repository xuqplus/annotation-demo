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
        Class clazz = User.class;
        Field[] fields = clazz.getFields(); // 所有public的, 包括继承的
        Field[] declaredFields = clazz.getDeclaredFields(); // 所有内部定义的
        Method[] methods = clazz.getMethods(); // 所有public的, 包括继承的
        Method[] declaredMethods = clazz.getDeclaredMethods(); // 所有内部定义的
        Annotation[] annotations = clazz.getAnnotations();
        Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();

        deal(clazz);
        deal(user, fields, declaredFields);
        deal(user, methods, declaredMethods);
    }

    private static void deal(Class clazz) {
        System.out.println(clazz.getName());
    }

    private static void deal(User user, Field[] fields, Field[] declaredFields) {
        /**
         * 每个二进制位所表示的修饰符
         * 查看 java.lang.reflect.Modifier
         */
        /**
         * field.setAccessible(true);
         * 查了下, 不是改modifiers的, 而是禁用"安全性检查"的, 禁用了在执行反射时可以省很多时间
         * 至于到底标查了什么没细看, |  --> java.lang.reflect.AccessibleObject
         */
        for (Field field : fields) {
            try {
                System.out.println(String.format("declaredFields, name=%s, modifiers=%s, value=%s", field.getName(), field.getModifiers(), field.get(user)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        for (Field field : declaredFields) {
            try {
                System.out.println(String.format("declaredFields, name=%s, modifiers=%s, value=%s", field.getName(), field.getModifiers(), field.get(user)));
            } catch (IllegalAccessException e) {
                System.err.println(String.format("declaredFields, name=%s, modifiers=%s", field.getName(), field.getModifiers()));
                // e.printStackTrace();
            }
        }
    }

    private static void deal(User user, Method[] methods, Method[] declaredMethods) {
        for (Method method : methods) {
            System.out.println(String.format("methods, name=%s, modifiers=%s", method.getName(), method.getModifiers()));
        }
    }
}