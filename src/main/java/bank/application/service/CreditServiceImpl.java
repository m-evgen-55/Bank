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
    private final BigDecimal ZERO_RETURN_SUM = BigDecimal.valueOf(0);

    @Inject
    private CreditDao creditDao;

    @Inject
    private ClientDao clientDao;


    @Override
    public Credit addNewCredit(final Integer clientId, final BigDecimal creditSum,
                               final int creditTimeInMonth, final BigDecimal monthSalary) {

        Client client = clientDao.getClientById(clientId).orElse(null);
        BigDecimal creditTime = BigDecimal.valueOf(creditTimeInMonth);
        BigDecimal monthPaymentForCreditWithoutProcent = creditSum.divide(creditTime, 5, BigDecimal.ROUND_CEILING);
        BigDecimal monthPaymentForCredit = monthPaymentForCreditWithoutProcent.multiply(YEAR_CREDIT_COEFFICIENT);
        boolean salaryCheck = monthSalary == monthSalary.max(monthPaymentForCredit);
        int creditRate = YEAR_CREDIT_COEFFICIENT.multiply(BigDecimal.valueOf(100)).
                subtract(BigDecimal.valueOf(100)).toBigInteger().shortValueExact();

        if (client != null) {
            if (client.getAge() < 50) {
                if (salaryCheck) {
                    Credit credit = new Credit();
                    credit.setClientRefId(clientId);
                    credit.setCreditRate(creditRate);
                    credit.setDuration(creditTimeInMonth);
                    credit.setReturnSum(ZERO_RETURN_SUM);
                    credit.setSumOfCredit(creditSum);
                    creditDao.insertCredit(credit);
                    return credit;
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
    public Credit payForCredit(final Integer creditId, final BigDecimal paySum) {
        Credit credit = creditDao.findCreditById(creditId).orElse(null);
        if (credit != null) {
            BigDecimal returnSum = credit.getReturnSum().add(paySum);
            credit.setReturnSum(returnSum);
            creditDao.insertCredit(credit);
            if (credit.getSumOfCredit().multiply(YEAR_CREDIT_COEFFICIENT).
                    compareTo(credit.getReturnSum()) == 0) {
                 //кинуть сообщение что кредит погашен
            }
            return credit;
        }
        // кинуть Exception что такой кредит не найден
        return null;
    }

    @Override
    public Integer getClientRefId(final Integer creditId) {
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
