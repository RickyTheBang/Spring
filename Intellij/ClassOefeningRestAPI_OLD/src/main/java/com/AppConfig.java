package com;



import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(scanBasePackages ={"com"})
@EnableTransactionManagement
public class AppConfig {



}
