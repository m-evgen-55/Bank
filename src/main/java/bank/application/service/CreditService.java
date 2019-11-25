package bank.application.service;

import bank.application.model.Credit;
import java.math.BigDecimal;


public interface CreditService {

    Credit addNewCredit (final Integer clientId, final BigDecimal creditSum,
                         final int creditTimeInMonth, final BigDecimal monthSalary);
    Credit payForCredit (final Integer creditId, final BigDecimal paySum);
    Integer getClientRefId (final Integer creditId);

}
