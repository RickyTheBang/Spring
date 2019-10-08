package Pokkemon.controller.implementation;


import Pokkemon.controller.CalcController;
import Pokkemon.repository.PokkemonRepository;
import Pokkemon.service.PokkemonCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("calcController")

public class CalcControllerImp implements CalcController {
    @Autowired
    PokkemonCalculatorService pokkemonCalcula;
    @Autowired
    PokkemonRepository pokkemonRepository;
}
