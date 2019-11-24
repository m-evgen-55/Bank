package bank.application.dao;

import bank.application.model.Account;

import java.math.BigDecimal;
import java.util.Optional;


public interface AccountDao {

    Account insertAccount(final Account account);
    Optional<Account> findAccountById(final Integer accountId);
    void deleteAccount(final Integer accountId);

}
