package Pokkemon.service.impl;

import Pokkemon.model.Pokkemon;
import Pokkemon.service.DustCalculatorService;
import Pokkemon.service.IVCalculatorService;

import Pokkemon.service.PokkemonCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokkemonCalculatorServiceImpl implements PokkemonCalculatorService {
    @Autowired(required = false)
    private IVCalculatorService ivService;
    @Autowired(required = false)
    private DustCalculatorService dustService;

    @Override
    public Pokkemon parsePokkemon(Pokkemon pokkemon) {
        if (ivService != null) ivService.calculateIV(pokkemon);
        if (dustService != null) dustService.calculateDust(pokkemon);

        return pokkemon;
    }
}
