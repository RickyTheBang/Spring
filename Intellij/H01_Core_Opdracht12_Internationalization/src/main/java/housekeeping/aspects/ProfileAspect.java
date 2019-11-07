package housekeeping.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ProfileAspect {

   @Around(value="execution(* housekeeping.*.runHousehold(..))")
   public Object around(ProceedingJoinPoint pjp) throws Throwable {
      long start = System.nanoTime();
      Object returnValue = pjp.proceed();
      long stop = System.nanoTime();
      long duration = stop - start;
      System.out.println("Duration: " + duration + " ns");
      return returnValue;
   }
}
