package Pokkemon.service.impl;

import Pokkemon.model.Pokkemon;
import Pokkemon.model.PokkemonType;
import Pokkemon.repository.PokkemonRepository;
import Pokkemon.repository.PokkemonTypeRepository;
import Pokkemon.service.TableRecordsCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class TableRecordsCreationServiceImpl  implements TableRecordsCreationService {

    @Autowired
    PokkemonTypeRepository pokkemonTypeRepository;
    @Autowired
    PokkemonRepository pokkemonRepository;

    public void createPokkemonTypeRecords(String pathName) throws IOException {

        // 1) The existing records are deleted
        pokkemonTypeRepository.deleteAllPokkemonType();

        //2) New records are created with data written in a text file
        BufferedReader reader = getBufferedReader(pathName);
        String line = null;
        PokkemonType pokkemonType = null;
        while ((line = reader.readLine()) != null) {

            String[] var = line.split("\\s");

            pokkemonType = new PokkemonType(var[4], var[3], Integer.parseInt(var[0]), Integer.parseInt(var[1]), Integer.parseInt(var[2]));
            pokkemonTypeRepository.savePokkemonType(pokkemonType);
        }

    }

    public void createPokkemonRecords(String pathName) throws IOException {

        // 1) The existing records are deleted
        pokkemonRepository.deleteAllPokkemon();


        //2) New records are created with data written in a text file
        BufferedReader reader = getBufferedReader(pathName);
        String line = null;
        Pokkemon pokkemon = null;
        while ((line = reader.readLine()) != null) {
            String[] var = line.split("\\s");

            PokkemonType pt = pokkemonTypeRepository.getPokkemonByTypeName(var[6]);

            Pokkemon p = new Pokkemon(var[5], pt, Integer.parseInt(var[0]), Integer.parseInt(var[1]),
                    Integer.parseInt(var[2]), Integer.parseInt(var[3]), Integer.parseInt(var[4]));

            pokkemonRepository.savePokkemon(p);

        }
    }

    private static BufferedReader getBufferedReader(String pathName) throws FileNotFoundException {
        Path pathPT = Paths.get(pathName);
        FileReader frPT = new FileReader(pathPT.toString());
        return new BufferedReader(frPT);
    }
}
