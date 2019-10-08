package Pokkemon.app;

import Pokkemon.AppConfig;
import Pokkemon.controller.CalcController;
import Pokkemon.model.Person;
import Pokkemon.model.Pokkemon;
import Pokkemon.model.User;
import Pokkemon.repository.PokkemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Menu {


   private static CalcController controller;

    @Autowired
    public void setCalcController(CalcController controller){
        this.controller = controller;
    }

    private static Person user =new User ();

  @Autowired
  public void setUser(Person user){
      this.user = user;
  }




    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(AppConfig.class, args);
        Scanner input = new Scanner (System.in);

        System.out.println ("What is your name?" );

        user.setName (input.next ());
        System.out.println ("What is your character level?" );
        user.setCharacterLevel (input.nextInt ());

        System.out.println ("Welcome " + user.getName ()+ ".");
        System.out.println ("Your character level is " + user.getCharacterLevel () );



        PokkemonRepository pr = ctx.getBean("pokkemonRepository", PokkemonRepository.class);


        List<Pokkemon> pokkemonList =pr.getAllPokkemons ();

        for(Pokkemon p : pokkemonList){
            System.out.println(p.getPokkemonName());
        }
    }

}
