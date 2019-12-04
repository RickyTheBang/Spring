package springMVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class WebApplication {

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource ms= new ResourceBundleMessageSource ();
        ms.setBasename ("messages");
        return ms;
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}
