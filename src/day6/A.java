package day6;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class A {

    @Before("execution(public void day6.Main.say())")
    public void before(JoinPoint point) {
        Main main = (Main) point.getTarget();
        System.out.println(main.getUser());
        System.out.println("before");
    }

    @After("execution(public void day6.*.say(..))")
    public void after(JoinPoint point) {
        Main main = (Main) point.getTarget();
        System.out.println(main.getUser());
        System.out.println("after");
    }
}
