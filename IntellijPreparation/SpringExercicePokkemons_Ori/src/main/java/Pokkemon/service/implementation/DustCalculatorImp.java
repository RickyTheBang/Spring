package Pokkemon.service.implementation;

import Pokkemon.service.DustCalculator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component("dustCalculator")
@Primary
public class DustCalculatorImp implements DustCalculator {
}
