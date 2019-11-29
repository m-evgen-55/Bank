package bank.application.service;

import bank.application.dao.AccountDao;
import bank.application.dao.ClientDao;
import bank.application.exception.AccountException;
import bank.application.exception.ClientException;
import bank.application.model.Account;
import bank.application.model.Client;
import org.springframework.stereotype.Component;
import javax.inject.Inject;
import java.math.BigDecimal;


@Component
public class AccountServiceImpl implements AccountService {

    @Inject
    private AccountDao accountDao;

    @Inject
    private ClientDao clientDao;


    @Override
    public Account addNewAccount(final Integer clientRefId, final BigDecimal putSum) throws ClientException {
        Client client = clientDao.getClientById(clientRefId).orElse(null);
        if (client != null) {
            Account account = new Account();
            account.setClienReftId(clientRefId);
            account.setBalance(putSum);
            return accountDao.insertAccount(account);
        }
        throw new ClientException("Клиент не найден.");
    }

    @Override
    public Account putMoney(final Integer accountId, final BigDecimal putSum) throws AccountException {
        Account account = accountDao.findAccountById(accountId).orElse(null);
        if (account != null) {
            if (putSum.compareTo(BigDecimal.valueOf(0)) > 0) {
                BigDecimal currentAccountBalance = account.getBalance();
                BigDecimal newAccountBallance = currentAccountBalance.add(putSum);
                account.setBalance(newAccountBallance);
                return accountDao.insertAccount(account);
            }
            throw new AccountException("Внесенная сумма отрицательна. Пожалуйста введите положительное число.");
        }
        throw new AccountException("Счет не найден.");
    }

    @Override
    public Account getMoney(final Integer accountId, final BigDecimal getSum) throws AccountException {
        Account account = accountDao.findAccountById(accountId).orElse(null);
        if (account != null) {
            BigDecimal currentAccountBalance = account.getBalance();
            if (getSum.compareTo(BigDecimal.valueOf(0)) > 0) {
                if (currentAccountBalance.compareTo(getSum) > 0 ||
                        currentAccountBalance.compareTo(getSum) == 0) {
                    BigDecimal newAccountBallance = currentAccountBalance.subtract(getSum);
                    account.setBalance(newAccountBallance);
                    return accountDao.insertAccount(account);
                }
                throw new AccountException("Не достаточно средств на счету.");
            }
            throw new AccountException("Запрашиваемая сумма отрицательна. Пожалуйста введите положительное число.");
        }
        throw new AccountException("Счет не найден.");
    }

    @Override
    public Account findAccountById(final Integer accountId) throws AccountException {
        Account account = accountDao.findAccountById(accountId).orElse(null);
        if (account != null) {
            return account;
        }
        throw new AccountException("Счет не найден.");
    }

    @Override
    public Integer getClientRefId(final Integer accountId) throws AccountException {
        Account account = accountDao.findAccountById(accountId).orElse(null);
        if (account != null) {
            Integer clientRefId = account.getClienReftId();
            if (clientRefId != null) {
                return clientRefId;
            }
            throw new AccountException("Счет не привязан ни к одному клиенту.");
        }
        throw new AccountException("Счет не найден.");
    }

    @Override
    public void deleteAccount(final Integer accountId) throws AccountException {
        Account account = accountDao.findAccountById(accountId).orElse(null);
        if (account != null) {
            accountDao.deleteAccount(accountId);
        } else {
            throw new AccountException("Счет не найден.");
        }

    }

}
