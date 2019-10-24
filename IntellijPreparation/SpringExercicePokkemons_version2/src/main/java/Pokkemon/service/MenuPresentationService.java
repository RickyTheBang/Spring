package Pokkemon.service;

import Pokkemon.model.Pokkemon;
import Pokkemon.model.PokkemonType;
import Pokkemon.model.Trainer;

import java.io.IOException;

public interface MenuPresentationService {


    void CreationRecords() throws IOException;

    Trainer userRegistration();

    void printListPokkemon();

    void printListPokkemonType();

    Pokkemon registerPokkemon(Trainer trainer);

    PokkemonType registerPokkemonType();

    int presentChoice();

    void printActualChoice(int choice);
}
