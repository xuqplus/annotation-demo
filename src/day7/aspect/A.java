package day7.aspect;

import day7.service.Run;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class A {

    @Pointcut(value = "execution(public void day7.service.Run.say(..))")
    public void pc() {
    }

    @Before(value = "pc()")
    public void before(JoinPoint point) {
        Run run = (Run) point.getTarget();
        System.out.println(run.getUser());
        System.out.println("before");
    }

    @After(value = "pc()")
    public void after(JoinPoint point) {
        Run run = (Run) point.getTarget();
        System.out.println(run.getUser());
        System.out.println("after");
    }
}
