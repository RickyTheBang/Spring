package Pokkemon.AppForTest;


import Pokkemon.AppConfig;
import Pokkemon.model.Pokkemon;
import Pokkemon.model.PokkemonType;
import Pokkemon.repository.PokkemonRepository;
import Pokkemon.repository.PokkemonTypeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

//@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@SpringBootApplication
public class PokkemonApp {
    public static void main(String[] args) {


        ConfigurableApplicationContext ctx = SpringApplication.run(AppConfig.class, args);
        PokkemonTypeRepository ptr = ctx.getBean("pokkemonTypeRepository", PokkemonTypeRepository.class);
        PokkemonType pokkemonType = new PokkemonType();
        pokkemonType.setBaseAttack(11);
        pokkemonType.setBaseDefense(21);
        pokkemonType.setBaseHitPoints(21);
        pokkemonType.setBeschrijving("Scarry");
        pokkemonType.setTypeName("Water");
        ptr.savePokkemonType(pokkemonType);


        PokkemonRepository pr = ctx.getBean("pokkemonRepository", PokkemonRepository.class);
        Pokkemon pokkemon = new Pokkemon ();
        pokkemon.setCombatPower(10);
        pokkemon.setIVAttack(10);
        pokkemon.setIVDefense(23);
        pokkemon.setIVHitPoints(12);
        pokkemon.setLevel(33);
        pokkemon.setPokkemonName("Squirtle");
        pokkemon.setPokkemonType(pokkemonType);
        pr.savePokkemon(pokkemon);

        List<Pokkemon> pokkemonList =pr.getAllPokkemons ();

        for(Pokkemon p : pokkemonList){
            System.out.println(p.getPokkemonName());
        }
    }
}