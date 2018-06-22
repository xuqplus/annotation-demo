package day7.aspect;

import day7.annotation.Message;
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

    /*@Before("execution(public * day7.service.Run.get*())")
    public void get(JoinPoint point) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Run run = (Run) point.getTarget();
        Class clazz = run.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Message.class)) {
                Message message = field.getAnnotation(Message.class);
                Method method = clazz.getMethod("set" + Util.upperFirst(field.getName()), message.msg().getClass());
                method.invoke(run, message.msg());
            }
        }
    }*/

    @Before("execution(public * day7.service.Run.get*())")
    public void get(JoinPoint point) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Object o = point.getTarget();
        Class clazz = o.getClass();
        String getter = point.getSignature().getName();
        Method setter = clazz.getMethod("s" + getter.substring(1), clazz.getMethod(getter).getReturnType());
        Field field = clazz.getDeclaredField(Util.lowerFirst(getter.substring(3)));
        if (field.isAnnotationPresent(Message.class)) {
            Message message = field.getAnnotation(Message.class);
            setter.invoke(o, message.msg());
        }
    }
}
