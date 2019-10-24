package h01_09_02_AOPmetSpring.aspect;

import h01_09_02_AOPmetSpring.model.MyExtraInterface;
import h01_09_02_AOPmetSpring.model.MyExtraInterfaceImpl;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @DeclareParents (value = "h01_09_02_AOPmetSpring.model.MyBean",
    defaultImpl = MyExtraInterfaceImpl.class)
    public static  h01_09_02_AOPmetSpring.model.MyExtraInterface mixin;

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
