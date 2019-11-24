package bank.application.controller;

import bank.application.model.Account;
import bank.application.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.UUID;


@RestController
public class AccountController {

    @Inject
    private AccountService accountService;

    @RequestMapping(value = "/addNewAccount", method = RequestMethod.POST)
    public void addNewAccount(
            @RequestParam("clientId") String clientId,
            @RequestParam("putSum") BigDecimal putSum
    ) {
        accountService.createNewAccount(toAccount(clientId, putSum));
    }


    private static Account toAccount(String clientId, BigDecimal putSum) {
        Account account = new Account();
        account.setAccountId(UUID.randomUUID().toString());
        account.setClienReftId(clientId);
        account.setBalance(putSum);
        return account;
    }

}
