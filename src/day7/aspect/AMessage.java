package day7.aspect;

import day7.annotation.Message;
import day7.service.Run;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Aspect
@Component
public class AMessage {

    @Before("execution(public * day7.service.Run.getMsg(..))")
    public void get(JoinPoint point) throws IllegalAccessException {
        Run run = (Run) point.getTarget();
        Class clazz = run.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Message.class)) {
                Message message = field.getAnnotation(Message.class);
                field.set(run, message.msg());
            }
        }
    }

    @Before("execution(public void day7.service.Run.set*())")
    public void set(JoinPoint point) {
        Run run = (Run) point.getTarget();
        System.out.println(run.getUser());
        System.out.println("initialization");
    }
}
