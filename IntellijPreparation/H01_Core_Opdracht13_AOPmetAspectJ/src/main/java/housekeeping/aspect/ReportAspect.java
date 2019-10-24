package housekeeping.aspect;


import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ReportAspect {

    @Before("execution(* *.runHouseHold(..))")
    public void before(){
        System.out.println ("*** ASPECT*** Before" );
    }
    @AfterReturning("execution(* *.runHouseHold(..))")
    public void afterReturning(){
        System.out.println ("*** ASPECT*** After Returning" );
    }
    @AfterThrowing("execution(* *.runHouseHold(..))")
    public void afterException(){
        System.out.println ("*** ASPECT*** After Exception" );
    }
    @After("execution(* *.runHouseHold(..))")
    public void after(){
        System.out.println ("*** ASPECT*** After" );
    }
}
