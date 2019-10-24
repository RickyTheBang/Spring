package Pokkemon.app;

import Pokkemon.AppConfig;
import Pokkemon.model.Trainer;
import Pokkemon.service.MenuPresentationService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.io.IOException;
import java.sql.SQLException;


public class Menu {

    public static void main(String[] args) throws IOException, SQLException {
        ConfigurableApplicationContext ctx = SpringApplication.run(AppConfig.class, args);
        MenuPresentationService menuPresentationService = ctx.getBean("menuPresentationService", MenuPresentationService.class);

        /*
        IF YOU WANT A FEW RECORDS IN THE TABLES POKKEMON AND POKKEMONTYPE, UNCOMMENT THE LINE BELOW THE FIRST TIME YOU RUN YOUR APPLICATION.
        THE SECOND TIME, COMMENT THIS LINE OF CODE AGAIN. OTHERWISE YOU'll LOST YOUR PREVIOUS RECORDINGS.
       */
        //0) Creation of records in the tables pokkemontype
       //menuPresentationService.CreationRecords();

        //1) Registration of the user
        Trainer user = menuPresentationService.userRegistration();

        //2) Menu
        int choice = menuPresentationService.presentChoice();
        menuPresentationService.printActualChoice(choice);


    }

}
