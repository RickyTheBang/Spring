package Pokkemon.app;

import Pokkemon.AppConfig;
import Pokkemon.controller.CalcController;
import Pokkemon.model.Pokkemon;
import Pokkemon.model.User;
import Pokkemon.model.utilities.TableRecordsCreation;
import Pokkemon.repository.PokkemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class Menu {

 @Autowired
    private static CalcController controller;




    public static void main(String[] args) throws IOException, SQLException {
        ConfigurableApplicationContext ctx = SpringApplication.run(AppConfig.class, args);

        //1) Creation of records in the table pokkemontype and pokkemon
        TableRecordsCreation tableRecordsCreation = ctx.getBean("tableRecordsCreation", TableRecordsCreation.class);
        tableRecordsCreation.createPokkemonTypeRecords("pokkemontype.txt");
        tableRecordsCreation.createPokkemonRecords("pokkemon.txt");




        User user = ctx.getBean("user", User.class);
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name?");

        user.setName(input.next());
        System.out.println("What is your character level?");
        user.setCharacterLevel(input.nextInt());

        System.out.println("Welcome " + user.getName() + ".");
        System.out.println("Your character level is " + user.getCharacterLevel());


        PokkemonRepository pr = ctx.getBean("pokkemonRepository", PokkemonRepository.class);


        List<Pokkemon> pokkemonList = pr.getAllPokkemons();

        for (Pokkemon p : pokkemonList) {
            System.out.println(p.getPokkemonName());
        }
    }

}
