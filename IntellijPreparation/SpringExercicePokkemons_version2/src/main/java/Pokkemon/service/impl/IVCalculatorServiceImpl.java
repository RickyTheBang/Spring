package Pokkemon.service.impl;

import Pokkemon.model.Pokkemon;
import Pokkemon.model.PokkemonType;
import Pokkemon.service.IVCalculatorService;
import org.springframework.stereotype.Service;

@Service
public class IVCalculatorServiceImpl
                implements IVCalculatorService {

    @Override
    public Pokkemon calculateIV(Pokkemon pokkemon) {
        Integer sumBase = calcBaseSum(pokkemon.getPokkemonType());
        Integer difference = pokkemon.getCombatPower() - sumBase;
        distributeValues(pokkemon, difference);

        return pokkemon;
    }

    private void distributeValues(Pokkemon pokkemon, Integer difference) {
        Integer increment = difference / 3;
        Integer leftOvers = difference % 3;

        pokkemon.setIVAttack(pokkemon.getPokkemonType().getBaseAttack() +
                (leftOvers > 0 ? increment + 1 : increment));
        pokkemon.setIVDefense(pokkemon.getPokkemonType().getBaseDefense() +
                (leftOvers > 1 ? increment + 1 : increment));
        pokkemon.setIVHitPoints(pokkemon.getPokkemonType().getBaseHitPoints() +
                increment);

    }

    private Integer calcBaseSum(PokkemonType type) {
        return type.getBaseAttack() +
                type.getBaseDefense() +
                type.getBaseHitPoints();
    }
}
