package com.imooc.Singer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class ManAspect {
    @Pointcut("execution(public * com.imooc.Singer.someone.*(..))")
    public void mancut(){}

//    @Before("mancut()")
//    public void before(){
//        System.out.println("###Before");
//    }
//
//    @After("mancut()")
//    public void after(){
//        System.out.println("###After");
//    }

    @Around("mancut()")
    public void around(ProceedingJoinPoint joinPoint){
        try{
            System.out.println("before");
            joinPoint.proceed();
            System.out.println("after");
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
    }

}
