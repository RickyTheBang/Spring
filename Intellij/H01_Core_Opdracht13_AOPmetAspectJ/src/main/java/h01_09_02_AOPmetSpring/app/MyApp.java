package h01_09_02_AOPmetSpring.app;


import h01_09_02_AOPmetSpring.config.AppConfigBook;
import h01_09_02_AOPmetSpring.model.MyExtraInterface;
import h01_09_02_AOPmetSpring.model.MyInterface;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        try(ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext (AppConfigBook.class)){
            MyInterface bean = ctx.getBean ("myBean",MyInterface.class);
            System.out.println (bean.sayHello ("Homer") );
            System.out.println (bean.sayGoodbye ("Homer") );
            MyExtraInterface bean2 = ctx.getBean ("myBean",MyExtraInterface.class);
            System.out.println (bean2.sayGoodnight ("Joe") );
        }
    }
}
