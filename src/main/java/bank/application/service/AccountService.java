package bank.application.service;

import bank.application.exception.AccountException;
import bank.application.exception.ClientException;
import bank.application.model.Account;
import java.math.BigDecimal;


public interface AccountService {

    Account addNewAccount(final Integer clientRefId, final BigDecimal putSum) throws ClientException;
    Account putMoney(final Integer accountId, BigDecimal putSum) throws AccountException;
    Account getMoney(final Integer accountId, final BigDecimal getSum) throws AccountException;
    Account findAccountById(final Integer accountId) throws AccountException;
    Integer getClientRefId(final Integer accountId) throws AccountException;
    void deleteAccount(final Integer accountId) throws AccountException;

}
