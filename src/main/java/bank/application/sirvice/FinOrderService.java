package bank.application.sirvice;

import bank.application.model.Credit;
import bank.application.model.CreditRequest;
import java.math.BigDecimal;
import java.net.CacheRequest;


public interface FinOrderService {

    Credit requestForCredit(CreditRequest creditRequest);
    Credit payForCredit(BigDecimal sumForPayment);

}
