package Pokkemon.service.impl;

import Pokkemon.model.Pokkemon;
import Pokkemon.service.DustCalculatorService;
import org.springframework.stereotype.Service;

@Service
public class DustCalculatorServiceImpl implements DustCalculatorService {
    @Override
    public Pokkemon calculateDust(Pokkemon pokkemon) {
        LevelEvaluator currentLevel = new LevelEvaluator(pokkemon.getLevel());
        int maxLevel = pokkemon.getTrainer().getLevel() + 1;
        int dustNeeded = 0;

        for ( ; currentLevel.isBelow(maxLevel); currentLevel.increment()) {
            if (currentLevel.isBetween(1, 4)) {
                dustNeeded += 100;
            }
            if (currentLevel.isBetween(5, 9)) {
                dustNeeded += 250;
            }
            if (currentLevel.isBetween(10, 19)) {
                dustNeeded += 1000;
            }
            if (currentLevel.isBetween(20, 99)) {
                int multiplier = (currentLevel.getValue() - 20) / 10;
                int dustNeededForLevel = 1500 + multiplier * 500;

                dustNeeded += dustNeededForLevel;
            }
            if (currentLevel.is(99)) {
                dustNeeded += 10000;
            }
            if (currentLevel.is(100)) {
                // Nothing to do here. Level is max
            }
        }

        return pokkemon.setDustToMaxLevel(dustNeeded);
    }

    private class LevelEvaluator {
        private Integer toEval;

        private LevelEvaluator(Integer number) {
            this.toEval = number;
        }

        public int getValue() {
            return this.toEval;
        }

        public void increment() {
            this.toEval++;
        }

        public boolean is(int i) {
            return this.toEval == i;
        }

        public boolean isBelow(int upperbound) {
            return this.toEval < upperbound;
        }

        public boolean isBetween(int lowerBound, int upperbound) {
            return this.toEval >= lowerBound && this.toEval <= upperbound;
        }
    }
}
