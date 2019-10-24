package Pokkemon.controller.implementation;


import Pokkemon.controller.CalcController;
import Pokkemon.repository.PokkemonRepository;
import Pokkemon.service.PokkemonCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("calcController")
@Primary

public class CalcControllerImp implements CalcController {
    //@Autowired
    PokkemonCalculatorService pokkemonCalculatorService;
   // @Autowired
    PokkemonRepository pokkemonRepository;
}
