package bank.application.dao;

import bank.application.model.Account;
import java.util.ArrayList;
import java.util.Optional;


public interface AccountDao {

    Account insertAccount(final Account account);
    Optional<Account> findAccountById(final Integer accountId);
    void deleteAccount(final Integer accountId);
    ArrayList<Account> getAllAccounts();

}
