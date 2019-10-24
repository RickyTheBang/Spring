/*
package Pokkemon.AppForTest;

import Pokkemon.AppConfig;
import Pokkemon.model.Pokkemon;
import Pokkemon.model.PokkemonType;
import Pokkemon.repository.PokkemonRepository;
import Pokkemon.repository.PokkemonTypeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PokkemonApp {
    public static void main(String[] args) throws IOException {


        ConfigurableApplicationContext ctx = SpringApplication.run(AppConfig.class, args);

        PokkemonTypeRepository ptr = ctx.getBean("pokkemonTypeRepository", PokkemonTypeRepository.class);
        PokkemonRepository pr = ctx.getBean("pokkemonRepository", PokkemonRepository.class);

        ptr.deleteAllPokkemonType();

        Path pathPT = Paths.get("pokkemontype.txt");
        FileReader frPT = new FileReader(pathPT.toString());
        BufferedReader readerPT = new BufferedReader(frPT);
        String linePT = null;
        while ((linePT = readerPT.readLine()) != null) {

            String[] var = linePT.split("\\s");


            PokkemonType pt = new PokkemonType(var[4], var[3], Integer.parseInt(var[0]), Integer.parseInt(var[1]), Integer.parseInt(var[2]));
            ptr.savePokkemonType(pt);



        }

        pr.deleteAllPokkemon();
        Path pathP = Paths.get("pokkemon.txt");
        FileReader frP = new FileReader(pathP.toString());
        BufferedReader readerP = new BufferedReader(frP);

        String lineP = null;
        while ((lineP = readerP.readLine()) != null) {

            String[] var = lineP.split("\\s");

           // System.out.println(var[6]);


        PokkemonType pt = ptr.getPokkemonByTypeName(var[6]);


            Pokkemon p = new Pokkemon(var[5],pt, Integer.parseInt(var[0]), Integer.parseInt(var[1]),
                    Integer.parseInt(var[2]), Integer.parseInt(var[3]), Integer.parseInt(var[4]));
            pr.savePokkemon(p);

        }
    }
}




*/
