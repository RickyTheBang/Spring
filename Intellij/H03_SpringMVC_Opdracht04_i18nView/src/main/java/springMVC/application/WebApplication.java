package springMVC.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = "springMVC")
public class WebApplication {
    @Bean
    public WebMvcConfigurer configurer() {
        return new WebMvcConfigurer ( ) {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController ("/welcome")
                        .setViewName ("welcome");
            }
        };

    }




    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}
