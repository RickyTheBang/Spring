package beers.app;

import beers.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeersApp {

        public static void main(String[] args) {
            SpringApplication.run (AppConfig.class, args);

            System.out.println ("hello" );
        }

    }

