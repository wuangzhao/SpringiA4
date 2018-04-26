package soundsystem;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SingerAspect {
    @Pointcut("execution(* soundsystem.Tony.singing(..))")
    public void pointcut(){}

    @Around("pointcut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        try {
            System.out.println("Before");
            proceedingJoinPoint.proceed();
            System.out.println("After");
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
    }

}
