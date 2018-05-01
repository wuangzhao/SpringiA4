package soundsystem;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SingerAspect {
    @Pointcut("execution(* soundsystem.Singer.singing(..))")
    public void pointcut(){}

//    @Around("pointcut()")
//    public void around(ProceedingJoinPoint proceedingJoinPoint){
//        try {
//            System.out.println("Before");
//            proceedingJoinPoint.proceed();
//            System.out.println("After");
//        } catch (Throwable throwable) {
//            System.out.println(throwable.getMessage());
//        }
//    }

    @Before("pointcut()")
    public void before(){
        System.out.println("***before");
    }

    @After("pointcut()")
    public void after(){
        System.out.println("***after");
    }

}
