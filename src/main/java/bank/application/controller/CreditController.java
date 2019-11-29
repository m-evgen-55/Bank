package bank.application.controller;

import bank.application.exception.ClientException;
import bank.application.exception.CreditException;
import bank.application.model.Credit;
import bank.application.service.CreditService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.inject.Inject;
import java.math.BigDecimal;


@RestController
public class CreditController {

    @Inject
    private CreditService creditService;


    @RequestMapping(value = "/getCredit", method = RequestMethod.POST)
    public Credit getCredit(
            @RequestParam("clientId") Integer clientId,
            @RequestParam("creditSum") BigDecimal creditSum,
            @RequestParam("creditTimeInMonth") int creditTimeInMonth,
                @RequestParam("monthSalary") BigDecimal monthSalary
    ) throws CreditException, ClientException {
        return creditService.addNewCredit(clientId, creditSum, creditTimeInMonth, monthSalary);
    }

    @RequestMapping(value = "/payForCredit", method = RequestMethod.POST)
    public Credit payForCredit(
            @RequestParam("creditId") Integer creditId,
            @RequestParam("putSum") BigDecimal paySum
    ) throws CreditException {
        return creditService.payForCredit(creditId, paySum);
    }

    @RequestMapping(value = "/getClientReferId", method = RequestMethod.GET)
    public Integer getClientReferId(
            @RequestParam("creditId") Integer clientId
    ) throws CreditException {
        return creditService.getClientRefId(clientId);
    }

}
