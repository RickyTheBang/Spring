package H01_09_AOP.service.implementation;

import H01_09_AOP.service.BankingOperationService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class BankingOperationServiceImplementation implements BankingOperationService {
    private List<String > statements = new ArrayList<> ();
    {
        statements.add ("Statment1");
    }
    @Override
    public void transfer(String accountA, String accountB, int amount) {
        System.out.println ("transfert" );
    }

    @Override
    public void withdrawal(String accountA, int amount) {
        System.out.println ("withdrawal" );
    }

    @Override
    public void deposit(String myAccountA, int amount) {
        System.out.println ("deposit" );
    }

    @Override
    public List<String> getBankStatements() {


        return statements;
    }
}
