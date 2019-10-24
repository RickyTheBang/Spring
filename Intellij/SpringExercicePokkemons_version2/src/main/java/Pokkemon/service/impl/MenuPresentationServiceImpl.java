package Pokkemon.service.impl;

import Pokkemon.configuration.TerminateBean;
import Pokkemon.controller.CalcController;
import Pokkemon.model.Pokkemon;
import Pokkemon.model.PokkemonType;
import Pokkemon.model.Trainer;
import Pokkemon.repository.PokkemonRepository;
import Pokkemon.repository.PokkemonTypeRepository;
import Pokkemon.service.MenuPresentationService;
import Pokkemon.service.TableRecordsCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Service("menuPresentationService")
public class MenuPresentationServiceImpl implements MenuPresentationService {
    @Autowired
    private TableRecordsCreationService tableRecordsCreationService;
    @Autowired
    private Trainer user;
    @Autowired
    private PokkemonRepository pokkemonRepository;
    @Autowired
    PokkemonTypeRepository pokkemonTypeRepository;
    @Autowired
    CalcController calcController;
    @Autowired
    ConfigurableApplicationContext ctx;

    Scanner input = new Scanner(System.in);


    @Override
    @Transactional
    public void CreationRecords() throws IOException {
        // Creation of records in the table pokkemontype and pokkemon
        tableRecordsCreationService.createPokkemonTypeRecords("pokkemontype.txt");
        tableRecordsCreationService.createPokkemonRecords("pokkemon.txt");

    }

    @Override
    public Trainer userRegistration() {


        System.out.println("What is your name?");

        user.setName(input.next());
        System.out.println("What is your character level?");
        user.setLevel(input.nextInt());

        System.out.println("Welcome " + user.getName() + ".");
        System.out.println("Your character level is " + user.getLevel());

        return user;
    }

    @Override
    public void printListPokkemon() {

        List<Pokkemon> pokkemonList = pokkemonRepository.getAllPokkemons();
        if (pokkemonList.size() != 0) {
            for (Pokkemon p : pokkemonList) {
                System.out.println(p);
            }
            System.out.println();
        } else {
            System.out.println("No Pokkemon yet");
        }

    }

    @Override
    public void printListPokkemonType() {
        List<PokkemonType> pokkemonTypeList = pokkemonTypeRepository.getAllPokkemonType();
        if (pokkemonTypeList.size() != 0) {
            for (PokkemonType p : pokkemonTypeList) {
                System.out.println(p.getTypeName());
            }
        } else {
            System.out.println("No PokkemonType yet");
        }

    }

    @Override
    public Pokkemon registerPokkemon(Trainer trainer) {

        Pokkemon pokkemon = conversationRegistrationPokkemon(trainer);
        calcController.calculateValuesPokkemon(pokkemon);
        System.out.println("Well done! You have a new Pokkemon to train!");
        System.out.println(pokkemon + "\n");
        return pokkemon;
    }

    @Override
    public PokkemonType registerPokkemonType() {

       PokkemonType pokkemonType = conversationRegistrationPokkemonType();

        System.out.println("Well done! This new type has been recorded!");
        System.out.println(pokkemonType + "\n");
        return pokkemonType;
    }

    @Override
    public int presentChoice() {
        String choice;
        System.out.println("Make your choice:");
        System.out.println("Print the list of Pokkemons : type 1");
        System.out.println("Register a new Pokkemon : type 2");
        System.out.println("Quit : type 3\n");

        choice = input.next();
        return Integer.parseInt(choice);
    }

    @Override
    public void printActualChoice(int choice) {
        switch (choice) {
            case 1:
                printListPokkemon();
                choiceLoop();
                break;
            case 2:
                registerPokkemon(user);
                choiceLoop();
                break;

            case 3:
                exitApplication(ctx);
                break;
            default:
                System.out.println("Incorrect choice! Try again!");
                choiceLoop();


        }
    }

    private void choiceLoop() {
        int choice = presentChoice();
        printActualChoice(choice);

    }

    private void exitApplication(ConfigurableApplicationContext ctx) {
        ctx.getBean(TerminateBean.class);
        ctx.close();
    }

    private Pokkemon conversationRegistrationPokkemon(Trainer trainer) {
        Pokkemon pokkemon = new Pokkemon();
        System.out.println("What is the PokkemonType?");
        System.out.println("Choose a type among the following list:\n");
        printListPokkemonType();
        String pokkemonTypeEntry = input.next();
        pokkemonTypeEntry =  messageForNonExistingType(pokkemonTypeEntry);


        PokkemonType pokkemonType = pokkemonTypeRepository.getPokkemonByTypeName(pokkemonTypeEntry);
        pokkemon.setPokkemonType(pokkemonType);
        System.out.println("What is the name the Pokkemon?\n");
        String name = input.next();
        pokkemon.setPokkemonName(name);
        System.out.println("What is the level of the Pokkemon?\n");
        int level = Integer.parseInt(input.next());
        pokkemon.setLevel(level);
        System.out.println("What is the CombatPower of the Pokkemon?\n");
        int combatPower = Integer.parseInt(input.next());
        pokkemon.setCombatPower(combatPower);

        pokkemon.setTrainer(trainer);
        return pokkemon;
    }

    private PokkemonType conversationRegistrationPokkemonType() {
        PokkemonType pokkemonType = new PokkemonType();
        System.out.println("What is the name of the PokkemonType?");
        String name = input.next();
        pokkemonType.setTypeName(name);


        System.out.println("What is the description of the PokkemonType?");
        String description = input.next();
        pokkemonType.setBeschrijving(description);


        System.out.println("What is the BaseAttack of the Pokkemon?\n");
        int baseAttack = Integer.parseInt(input.next());
        pokkemonType.setBaseAttack(baseAttack);

        System.out.println("What is the BaseDefense of the Pokkemon?\n");
        int baseDefense = Integer.parseInt(input.next());
        pokkemonType.setBaseDefense(baseDefense);

        System.out.println("What is the BaseHitPoints of the Pokkemon?\n");
        int baseHitPoints = Integer.parseInt(input.next());
        pokkemonType.setBaseHitPoints(baseHitPoints);
        pokkemonTypeRepository.savePokkemonType(pokkemonType);


        return pokkemonType;
    }

    private String messageForNonExistingType(String pokkemonTypeEntry){
        List<String> pokkemonTypeNameList = pokkemonTypeRepository.getAllPokkemonTypeName();
        if(! pokkemonTypeNameList.contains(pokkemonTypeEntry)){
            System.out.println("Well, we don't have the type! Please create this new type.");
            System.out.println("Follow the instructions:");
           PokkemonType pokkemonType = registerPokkemonType();
           return  pokkemonType.getTypeName();

        }else{
            return pokkemonTypeEntry;
        }
    }

}
