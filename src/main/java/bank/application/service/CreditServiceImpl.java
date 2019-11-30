package bank.application.service;

import bank.application.dao.ClientDao;
import bank.application.dao.CreditDao;
import bank.application.exception.ClientException;
import bank.application.exception.CreditException;
import bank.application.model.Client;
import bank.application.model.Credit;
import org.springframework.stereotype.Component;
import javax.inject.Inject;
import java.math.BigDecimal;


@Component
public class CreditServiceImpl implements CreditService {

    private final BigDecimal YEAR_CREDIT_COEFFICIENT = BigDecimal.valueOf(1.1);
    private final BigDecimal ZERO_RETURN_SUM = BigDecimal.valueOf(0);
    private final int MAX_CLIENT_AGE = 50;

    @Inject
    private CreditDao creditDao;

    @Inject
    private ClientDao clientDao;


    // для одобрения кредита клиент должен отвечать следующим условиям:
    // - быть меньше 50 лет
    // - месячный пдатеж по кредиту с учетом процентов должен быть меньше его месячной зп
    @Override
    public Credit addNewCredit(final Integer clientId, final BigDecimal creditSum,
                               final int creditTimeInMonth, final BigDecimal monthSalary) throws CreditException, ClientException {

        Client client = clientDao.getClientById(clientId).orElse(null);
        BigDecimal creditTime = BigDecimal.valueOf(creditTimeInMonth);
        BigDecimal monthPaymentForCreditWithoutProcent = creditSum.divide(creditTime, 5, BigDecimal.ROUND_CEILING);
        BigDecimal monthPaymentForCredit = monthPaymentForCreditWithoutProcent.multiply(YEAR_CREDIT_COEFFICIENT);
        boolean salaryCheck = monthSalary == monthSalary.max(monthPaymentForCredit);
        int creditRate = YEAR_CREDIT_COEFFICIENT.multiply(BigDecimal.valueOf(100)).
                subtract(BigDecimal.valueOf(100)).toBigInteger().shortValueExact();

        if (client != null) {
            if (client.getAge() < MAX_CLIENT_AGE) {
                if (salaryCheck) {
                    Credit credit = new Credit();
                    credit.setClientRefId(clientId);
                    credit.setCreditRate(creditRate);
                    credit.setDuration(creditTimeInMonth);
                    credit.setReturnSum(ZERO_RETURN_SUM);
                    credit.setSumOfCredit(creditSum);
                    credit.setPaidOff(false);
                    creditDao.insertCredit(credit);
                    return credit;
                }
                throw new CreditException("Клиенту не одобрен кредит т.к. представленных клиентом доходов недостаточно.");
            }
            throw new CreditException("Клиенту не одобрен кредит т.к. клиент не подходит по возрасту.");
        }
        throw new ClientException("Клиент не найден.");
    }

    // в методе осуществляется проверка погашен ли кредит. Нельзя внести платеж по погашенному кредиту
    @Override
    public Credit payForCredit(final Integer creditId, final BigDecimal paySum) throws CreditException {
        Credit credit = creditDao.findCreditById(creditId).orElse(null);
        if (credit != null) {
            if (!credit.isPaidOff()) {
                BigDecimal returnSum = credit.getReturnSum().add(paySum);
                credit.setReturnSum(returnSum);
                creditDao.insertCredit(credit);
                if (credit.getSumOfCredit().multiply(YEAR_CREDIT_COEFFICIENT).
                        compareTo(credit.getReturnSum()) == 0) {
                    credit.setPaidOff(true);
                    creditDao.insertCredit(credit);
                }
                return credit;
            }
            throw new CreditException("Платеж не принят. Кредит погашен.");
        }
        throw new CreditException("Кредит не найден.");
    }

    @Override
    public Integer getClientRefId(final Integer creditId) throws CreditException {
        Credit credit = creditDao.findCreditById(creditId).orElse(null);
        if (credit != null) {
            Integer clientRefId = credit.getClientRefId();
            if (clientRefId != null) {
                return clientRefId;
            }
            throw new CreditException("Кредит не привязан ни к одному клиенту.");
        }
        throw new CreditException("Кредит не найден.");
    }

}
