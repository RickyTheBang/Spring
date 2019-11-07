package housekeeping.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ReportAspect {
   @Before("execution(* *.runHousehold(..))")
   public void before(){      
      System.out.println("Before");
   }

   @AfterReturning("execution(* *.runHousehold(..))")
   public void afterReturning() {
      System.out.println("AfterReturning");
   }

   @AfterThrowing("execution(* *.runHousehold(..))")
   public void afterException() {
      System.out.println("AfterException");
   }

   @After("execution(* *.runHousehold(..))")
   public void after(){      
      System.out.println("After");
   }
}
