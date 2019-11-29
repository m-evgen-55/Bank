package bank.application.dao;

import bank.application.model.Account;
import bank.application.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Optional;


@Component
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Account insertAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> findAccountById(Integer accountId) {
        return accountRepository.findById(accountId);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountRepository.deleteById(accountId);
    }

    @Override
    public ArrayList<Account> getAllAccounts() {
        ArrayList<Account> allAccounts = (ArrayList<Account>) accountRepository.findAll();
        return allAccounts;
    }

}
