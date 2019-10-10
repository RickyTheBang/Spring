package H01_09_AOP.app;

import H01_09_AOP.AppConfig;
import H01_09_AOP.service.BOSSNoInterfaceImplementation;
import H01_09_AOP.service.BankingOperationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext (AppConfig.class);
        //ctx.getBean ()
        BankingOperationService service  =ctx.getBean (BankingOperationService.class);
        service.transfer ("a","b",10);


        BOSSNoInterfaceImplementation boss  =ctx.getBean (BOSSNoInterfaceImplementation.class);
        boss.transfer ();

    }
}
