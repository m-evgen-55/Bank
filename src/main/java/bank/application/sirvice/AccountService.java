package bank.application.sirvice;

import bank.application.model.Account;
import sun.management.counter.AbstractCounter;
import java.math.BigDecimal;
import java.math.BigInteger;


public interface AccountService {

    Account createNewAccount(Account account);
    Account putMoney(BigDecimal putSum);
    Account getMoney(BigDecimal getSum);
    Account getClientRefId(String Id);

}
