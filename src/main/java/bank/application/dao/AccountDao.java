package bank.application.dao;

import bank.application.model.Account;
import java.math.BigDecimal;


public interface AccountDao {

    Account insertAccount(final Account account);
    Account putMoney(final BigDecimal putSum);
    Account getManey(final BigDecimal getSum);
    Account deleteAccount(final Account account);
    Account findById(final String Id);
    Account getClientRefId(final String Id);

}
