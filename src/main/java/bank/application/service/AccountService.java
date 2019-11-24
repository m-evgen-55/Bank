package bank.application.service;

import bank.application.model.Account;
import bank.application.model.Client;
import java.math.BigDecimal;


public interface AccountService {

    Account addNewAccount(final Account account);
    Account putMoney(final Integer accountId, BigDecimal putSum);
    Account getMoney(final Integer accountId, final BigDecimal getSum);
    Account findAccountById(final Integer accountId);
    Client getClientRefId(final Integer accountId);
    void deleteAccount(final Integer accountId);

}
