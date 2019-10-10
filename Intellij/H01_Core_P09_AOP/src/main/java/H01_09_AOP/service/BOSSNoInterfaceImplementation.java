package H01_09_AOP.service;


import org.springframework.stereotype.Component;

@Component
public class BOSSNoInterfaceImplementation {

    public void transfer(){
        System.out.println ("print BOSS" );
    }
}
