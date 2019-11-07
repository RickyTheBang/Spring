package H01_09_AOP;

import H01_09_AOP.model.MyBean;
import H01_09_AOP.model.MyInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AppConfig {



    @Bean
    public MyInterface myBean() {
        return new MyBean ();
    }
}
