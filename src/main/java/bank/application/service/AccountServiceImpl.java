package bank.application.service;

import bank.application.dao.AccountDao;
import bank.application.dao.ClientDao;
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
    public Account addNewAccount(final Account account) {
        return accountDao.insertAccount(account);
    }

    @Override
    public Account putMoney(final Integer accountId, final BigDecimal putSum) {
        Account account = accountDao.findAccountById(accountId).orElse(null);
        // если account == null, кинуть Exception что аккаунт не найден
        BigDecimal currentAccountBallance = account.getBalance();
        // реализовать проверку что внесенная сумма положительня
        BigDecimal newAccountBallance = currentAccountBallance.add(putSum);
        account.setBalance(newAccountBallance);
        return accountDao.insertAccount(account);
    }

    @Override
    public Account getMoney(final Integer accountId, final BigDecimal getSum) {
        Account account = accountDao.findAccountById(accountId).orElse(null);
        // если account == null, кинуть Exception что аккаунт не найден
        BigDecimal currentAccountBallance = account.getBalance();
        // реализовать проверку что запрашиваемая сумма положительна
        if (currentAccountBallance.compareTo(getSum) == 1 |
                currentAccountBallance.compareTo(getSum) == 0) {
            BigDecimal newAccountBallance = currentAccountBallance.subtract(getSum);
            account.setBalance(newAccountBallance);
            return accountDao.insertAccount(account);
        }
        // сделать Exception что недостаточно средств на счету
        return null;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId).orElse(null);
        // если account == null, кинуть Exception что аккаунт не найден
    }

    @Override
    public Integer getClientRefId(final Integer accountId) {
        //return accountDao.getClientRefId(clientRefId);
        Account account = accountDao.findAccountById(accountId).orElse(null);
        // если account == null, кинуть Exception что аккаунт не найден
        return account.getClienReftId();
        // если не найден clientRefId то кинуть Exception что аккаунт не привязан
        // ни к одному клиенту и удалить аккаунт
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

}
