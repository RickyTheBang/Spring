package Pokkemon.service;

import Pokkemon.model.PokkemonType;

import java.io.BufferedReader;
import java.io.IOException;

public interface TableRecordsCreationService {

    void createPokkemonTypeRecords(String pathName) throws IOException ;

     void createPokkemonRecords(String pathName) throws IOException;
}
