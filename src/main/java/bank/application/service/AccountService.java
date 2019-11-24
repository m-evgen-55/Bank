package bank.application.service;

import bank.application.model.Account;

import java.math.BigDecimal;


public interface AccountService {

    Account createNewAccount(Account account);
    Account putMoney(BigDecimal putSum);
    Account getMoney(BigDecimal getSum);
    Account getClientRefId(String Id);

}
