package Pokkemon.controller.implementation;


import Pokkemon.controller.CalcController;
import Pokkemon.repository.PokkemonRepository;
import Pokkemon.service.PokkemonCalcula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("calcController")
@Primary
public class CalcControllerImp implements CalcController {
    @Autowired
    PokkemonCalcula pokkemonCalcula;
    @Autowired
    PokkemonRepository pokkemonRepository;
}
