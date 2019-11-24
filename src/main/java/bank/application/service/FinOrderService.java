package bank.application.service;

import bank.application.model.Credit;
import bank.application.model.CreditRequest;
import java.math.BigDecimal;


public interface FinOrderService {

    Credit requestForCredit(CreditRequest creditRequest);
    Credit payForCredit(BigDecimal sumForPayment);

}
