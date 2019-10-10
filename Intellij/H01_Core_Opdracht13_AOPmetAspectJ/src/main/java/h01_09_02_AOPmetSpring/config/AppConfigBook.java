package h01_09_02_AOPmetSpring.config;


import h01_09_02_AOPmetSpring.model.MyBean;
import h01_09_02_AOPmetSpring.model.MyInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AppConfigBook {



    @Bean
    public MyInterface myBean() {
        return new MyBean ();
    }
}
