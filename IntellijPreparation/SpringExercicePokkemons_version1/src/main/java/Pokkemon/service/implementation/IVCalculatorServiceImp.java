package Pokkemon.service.implementation;

import Pokkemon.model.Pokkemon;
import Pokkemon.model.PokkemonType;
import Pokkemon.model.Trainer;
import Pokkemon.service.IVCalculatorService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("IVCalculator")
@Primary
public class IVCalculatorServiceImp implements IVCalculatorService {
    @Override
    public Pokkemon calculateIV(Pokkemon pokkemon) {
        int sumBase = calcBaseSum(pokkemon.getPokkemonType ());
        int difference = pokkemon.getCombatPower () - sumBase;
        distributeValues(pokkemon,difference);
        return pokkemon;
    }

    private void distributeValues(Pokkemon pokkemon, int difference) {
        int increment = difference/3;
        int leftOvers = difference%3;
        pokkemon.setIVAttack (pokkemon.getPokkemonType ().getBaseAttack () +(leftOvers>0? increment+1:increment));
        pokkemon.setIVDefense (pokkemon.getPokkemonType ().getBaseDefense ()+(leftOvers>1? increment+1:increment));
        pokkemon.setIVHitPoints (pokkemon.getPokkemonType ().getBaseHitPoints () +increment);
    }

    private int calcBaseSum(PokkemonType pokkemonType) {
        return pokkemonType.getBaseAttack ( )+
                pokkemonType.getBaseDefense ( )+
                pokkemonType.getBaseHitPoints ( );
    }
}
