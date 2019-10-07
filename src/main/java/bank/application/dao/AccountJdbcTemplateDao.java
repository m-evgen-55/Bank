package bank.application.dao;

import bank.application.model.Account;
import bank.application.model.Client;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Component
public class AccountJdbcTemplateDao implements AccountDao {

    private final static List<Account> ACCOUNTS = new ArrayList<>();


    // в этом методе записать insert  в базу данных
    @Override
    public Account insertAccount(Account account) {
        ACCOUNTS.add(account);
        return account;
    }

    @Override
    public Account putMoney(BigDecimal putSum) {
        return null;
    }

    @Override
    public Account getManey(BigDecimal getSum) {
        return null;
    }

    @Override
    public Account deleteAccount(Account account) {
        return null;
    }

    @Override
    public Account findById(String Id) {

        for (Account a: ACCOUNTS) {
            if (a.getAccountId().equals(Id)) {
                return a;
            }
        }
        return null;
    }

    @Override
    public Account getClientRefId(String Id) {
        for (Account a: ACCOUNTS) {
            if (a.getClienReftId().equals(Id)){
                return a;
            }
        }
        return null;
    }

}
