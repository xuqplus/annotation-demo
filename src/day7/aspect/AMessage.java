package day7.aspect;

import day7.annotation.Message;
import day7.service.Run;
import day7.util.Util;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Aspect
@Component
public class AMessage {

    @Before("execution(public * day7.service.Run.get*())")
    public void get(JoinPoint point) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Run run = (Run) point.getTarget();
        Class clazz = run.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Message.class)) {
                Message message = field.getAnnotation(Message.class);
                Method method = clazz.getMethod("set" + Util.uppperFirst(field.getName()), message.msg().getClass());
                method.invoke(run, message.msg());
            }
        }
    }
}
