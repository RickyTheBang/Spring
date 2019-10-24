package Pokkemon.service.implementation;

import Pokkemon.model.Pokkemon;
import Pokkemon.service.DustCalculatorService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component("dustCalculator")
@Primary
public class DustCalculatorServiceImp implements DustCalculatorService {
    @Override
    public Pokkemon calculateDust(Pokkemon pokkemon) {
        return null;
    }
}
