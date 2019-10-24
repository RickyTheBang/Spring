package H01_09_AOP.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Component
@Aspect
public class AuditingAspect {
    @Before("execution(* *.transfer(..))")
    public void before() {
        System.out.println ("Auditing aspect : Before");
    }

    @After("execution(* *.transfer(..))")
    public void after() {
        System.out.println ("Auditing aspect : After");
    }

    @Around("execution(* *.transfer(..))")
    public void around(ProceedingJoinPoint point) throws Throwable {
        LocalTime start = LocalTime.now ( );
        point.proceed ( );
        LocalTime end = LocalTime.now ( );
        System.out.println ("Method took: " + ChronoUnit.MILLIS.between (start, end));
    }

    @AfterThrowing(value = "execution(* *.transfer(..))",throwing = "ex")
    public void afterThrowing(Throwable ex){
    }


}
