package Pokkemon.service.implementation;

import Pokkemon.model.Pokkemon;
import Pokkemon.service.DustCalculatorService;
import Pokkemon.service.IVCalculatorService;
import Pokkemon.service.PokkemonCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Component("pokkemonCalcula")
@Primary
public class PokkemonCalculatorServiceImp implements PokkemonCalculatorService {
    @Autowired(required = false)
    IVCalculatorService ivCalculator;
    @Autowired(required = false)
    DustCalculatorService dustCalculator;

    @Override
    public Pokkemon parsePokkemon(Pokkemon pokkemon) {
        if(ivCalculator!=null){
            ivCalculator.calculateIV (pokkemon);
        }
        if(dustCalculator!=null){
            dustCalculator.calculateDust (pokkemon);
        }

        return pokkemon;
    }
}
