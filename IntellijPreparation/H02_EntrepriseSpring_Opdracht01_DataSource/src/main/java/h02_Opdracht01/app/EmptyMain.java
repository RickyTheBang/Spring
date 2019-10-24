package h02_Opdracht01.app;

import h02_Opdracht01.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class EmptyMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =SpringApplication.run(AppConfig.class,args);
		System.out.println("nothing");
		 
	}
	

}

