package bank.application.service;

import bank.application.dao.ClientDao;
import bank.application.dao.CreditDao;
import bank.application.model.Client;
import bank.application.model.Credit;
import org.springframework.stereotype.Component;
import javax.inject.Inject;
import java.math.BigDecimal;


@Component
public class CreditServiceImpl implements CreditService {

    private final BigDecimal YEAR_CREDIT_COEFFICIENT = BigDecimal.valueOf(1.1);

    @Inject
    private CreditDao creditDao;

    @Inject
    private ClientDao clientDao;


    @Override
    public Credit addNewCredit(Integer clientId, BigDecimal creditSum,
                               int creditTimeInMonth, BigDecimal monthSalary) {

        Client client = clientDao.getClientById(clientId).orElse(null);
        BigDecimal creditTime = BigDecimal.valueOf(creditTimeInMonth);
        BigDecimal monthPaymentForCredit = creditSum.divide(creditTime).multiply(YEAR_CREDIT_COEFFICIENT);
        boolean salaryCheck = monthSalary == monthSalary.max(monthPaymentForCredit);

        if (client != null) {
            if (client.getAge() < 50) {
                if (salaryCheck) {
                    Credit credit = new Credit();
                    credit.setClientRefId(clientId);
                    credit.setCreditRate(YEAR_CREDIT_COEFFICIENT.shortValueExact());
                    credit.setDuration(creditTimeInMonth);
                    credit.setSumOfCredit(creditSum);
                    return creditDao.insertCredit(credit);
                }
                // кинуть Exception что клиенту не одобрен кредит т.к. маленькая зп
                return null;
            }
            // кинуть Exception что клиент не проходит по возрасту
            return null;
        }
        // кинуть Exception что такого клиента не существует
        return null;

    }

    @Override
    public Credit payForCredit(Integer creditId, BigDecimal paySum) {
        Credit credit = creditDao.findCreditById(creditId).orElse(null);
        if (credit != null) {
            credit.setReturnSum(credit.getReturnSum().add(paySum));
            if (credit.getSumOfCredit().multiply(YEAR_CREDIT_COEFFICIENT).
                    compareTo(credit.getReturnSum()) == 0) {
                // кинуть сообщение что кредит погашен
            }
        }
        // кинуть Exception что такой кредит не найден
        return null;
    }

    @Override
    public Integer getClientRefId(Integer creditId) {
        Credit credit = creditDao.findCreditById(creditId).orElse(null);
        if (credit != null) {
            Integer clientRefId = credit.getClientRefId();
            if (clientRefId != null) {
                return clientRefId;
            }
            // кинуть Exception что кредит не привязан ни к какому клиенту
            // удалить кредит
            return null;
        }
        // кинуть Exception что кредит не найден
        return null;
    }

}
