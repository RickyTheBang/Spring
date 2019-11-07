package com.app;

import com.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestDemoInitApplication {

    public static void main(String[] args) {
        SpringApplication.run (AppConfig.class, args);
    }

}
