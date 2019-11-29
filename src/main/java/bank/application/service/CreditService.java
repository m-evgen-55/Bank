package bank.application.service;

import bank.application.exception.ClientException;
import bank.application.exception.CreditException;
import bank.application.model.Credit;
import java.math.BigDecimal;


public interface CreditService {

    Credit addNewCredit (final Integer clientId, final BigDecimal creditSum,
                         final int creditTimeInMonth, final BigDecimal monthSalary) throws CreditException, ClientException;
    Credit payForCredit (final Integer creditId, final BigDecimal paySum) throws CreditException;
    Integer getClientRefId (final Integer creditId) throws CreditException;

}
