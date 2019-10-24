package Pokkemon.service.implementation;

import Pokkemon.service.DustCalculator;
import Pokkemon.service.IVCalculator;
import Pokkemon.service.PokkemonCalcula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Component("pokkemonCalcula")
@Primary
public class PokkemonCalculaImp implements PokkemonCalcula {
    @Autowired
    IVCalculator ivCalculator;
    @Autowired
    DustCalculator dustCalculator;
}
