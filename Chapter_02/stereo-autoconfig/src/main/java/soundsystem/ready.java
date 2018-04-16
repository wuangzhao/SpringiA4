package soundsystem;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ready {
    @Pointcut("execution(* *soundsystem.CompactDisc.play(..))")
    public void pread() {}

    @Before("pread()")
    public void info(){
        System.out.println("hh");
    }
}
