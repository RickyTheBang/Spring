package H01_09_AOP;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    @Before ("execution(* *.sayHello(..))")
    public void before(){
        System.out.println ("Before" );
    }

    @AfterReturning("execution(* *.sayHello(..))")
    public void afterReturning(){
        System.out.println ("After Returning" );
    }
    @AfterThrowing("execution(* *.sayHello(..))")
    public void afterException(){
        System.out.println ("After Exception" );
    }
    @After("execution(* *.sayHello(..))")
    public void after(){
        System.out.println ("After" );
    }





}
