package day5;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class A {

    @Before("execution(* day5.Main.say())")
    public void before() {
        System.out.println("before");
    }

    @After("execution(* day5.*.say(..))")
    public void after() {
        System.out.println("after");
    }
}
