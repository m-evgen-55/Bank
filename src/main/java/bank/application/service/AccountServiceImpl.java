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
    public Account createNewAccount(final Account account) {
        return accountDao.insertAccount(account);
    }

    @Override
    public Account putMoney(final BigDecimal putSum) {
        return accountDao.putMoney(putSum);
    }

    @Override
    public Account getMoney(final BigDecimal getSum) {

        return accountDao.getManey(getSum);
    }

    @Override
    public Account getClientRefId(final String Id) {
        return accountDao.getClientRefId(Id);
    }

}
