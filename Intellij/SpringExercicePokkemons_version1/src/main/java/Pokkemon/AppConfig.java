package Pokkemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import javax.persistence.Column;


@SpringBootApplication(scanBasePackages = "Pokkemon")
//@Configuration
//@ComponentScan("Pokkemon")
//@PropertySource({"classpath:application.properties"})
public class AppConfig {


}
