package soapProject.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import soapProject.AppConfig;

@SpringBootApplication
public class HelloApp {
    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class,args);
    }


}
