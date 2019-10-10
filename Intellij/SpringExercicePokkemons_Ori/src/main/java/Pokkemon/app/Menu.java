package Pokkemon.app;

import Pokkemon.AppConfig;
import Pokkemon.controller.CalcController;
import Pokkemon.model.Pokkemon;
import Pokkemon.repository.PokkemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

public class Menu {

    @Autowired
    CalcController controller;





    public static void main(String[] args) {


        ConfigurableApplicationContext ctx = SpringApplication.run(AppConfig.class, args);



        PokkemonRepository pr = ctx.getBean("pokkemonRepository", PokkemonRepository.class);


        List<Pokkemon> pokkemonList =pr.getListPokkemons();

        for(Pokkemon p : pokkemonList){
            System.out.println(p.getPokkemonName());
        }
    }

}
