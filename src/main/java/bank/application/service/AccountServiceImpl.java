package bank.application.service;

import bank.application.dao.AccountDao;
import bank.application.model.Account;
import org.springframework.stereotype.Component;
import javax.inject.Inject;
import java.math.BigDecimal;


@Component
public class AccountServiceImpl implements AccountService {

    @Inject
    private AccountDao accountDao;


    @Override
    public Account addNewAccount(final Integer clientRefId, final BigDecimal putSum) {
        Account account = new Account();
        account.setClienReftId(clientRefId);
        account.setBalance(putSum);
        return accountDao.insertAccount(account);
    }

    @Override
    public Account putMoney(final Integer accountId, final BigDecimal putSum) {
        Account account = accountDao.findAccountById(accountId).orElse(null);
        if (account != null) {
            if (putSum.compareTo(putSum.max(BigDecimal.valueOf(0))) == 1) {
                BigDecimal currentAccountBalance = account.getBalance();
                BigDecimal newAccountBallance = currentAccountBalance.add(putSum);
                account.setBalance(newAccountBallance);
                return accountDao.insertAccount(account);
            }
            // кинуть Exception что внесенная сумма отрицательна
            return null;
        }
        // кинуть Exception что аккаунт не найден
        return null;
    }

    @Override
    public Account getMoney(final Integer accountId, final BigDecimal getSum) {
        Account account = accountDao.findAccountById(accountId).orElse(null);
        BigDecimal currentAccountBalance = account.getBalance();
        if (account != null) {
            if (getSum.compareTo(getSum.max(BigDecimal.valueOf(0))) ==1) {
                if (currentAccountBalance.compareTo(getSum) == 1 |
                        currentAccountBalance.compareTo(getSum) == 0) {
                    BigDecimal newAccountBallance = currentAccountBalance.subtract(getSum);
                    account.setBalance(newAccountBallance);
                    return accountDao.insertAccount(account);
                }
                // кинуть Exception что недостаточно средств на счету
                return null;
            }
            // кинуть Exception что запрашиваемая сумма отрицательна
            return null;
        }
        // кинуть Exception что аккаунт не найден
        return null;
    }

    @Override
    public Account findAccountById(final Integer accountId) {
        Account account = accountDao.findAccountById(accountId).orElse(null);
        if (account != null) {
            return account;
        }
        // кинуть Exception что аккаунт не найден
        return null;
    }

    @Override
    public Integer getClientRefId(final Integer accountId) {
        Account account = accountDao.findAccountById(accountId).orElse(null);
        if (account != null) {
            Integer clientRefId = account.getClienReftId();
            if (clientRefId != null) {
                return clientRefId;
            }
            // кинуть Exception что аккаунт не привязан ни к одному клиенту
            // удалить аккаунт
            return null;
        }
        // кинуть Exception что аккаунт не найден
        return null;
    }

    @Override
    public void deleteAccount(final Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

}
