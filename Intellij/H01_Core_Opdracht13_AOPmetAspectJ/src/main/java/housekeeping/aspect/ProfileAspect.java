package housekeeping.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Component
@Aspect
public class ProfileAspect {

    @Around("execution(* *.runHouseHold(..))")
    public void around(ProceedingJoinPoint point) throws Throwable {
        LocalTime start = LocalTime.now ( );
        point.proceed ( );
        LocalTime end = LocalTime.now ( );
        System.out.println ("Method took: " + ChronoUnit.MILLIS.between (start, end) + " milliseconds.");
    }
}
