package H01_09_AOP.service;

import java.util.List;

public interface BankingOperationService {

    void transfer(String accountA, String accountB, int amount);
    void withdrawal(String accountA, int amount);
    void deposit(String myAccountA, int amount);
    List<String> getBankStatements();

}
