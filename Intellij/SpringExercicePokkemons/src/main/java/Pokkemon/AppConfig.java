package Pokkemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@SpringBootApplication(scanBasePackages = "Pokkemon")
//@PropertySource({"classpath:application.properties"})
public class AppConfig {

    public static void main(String[] args) {
        SpringApplication.run (AppConfig.class, args);
    }

}
