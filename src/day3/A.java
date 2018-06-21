package day3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class A {

    @Before("execution(* day3.*.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("before");
    }
}
