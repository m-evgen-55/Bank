package bank.application.controller;

import bank.application.model.Account;
import bank.application.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.inject.Inject;
import java.math.BigDecimal;


@RestController
public class AccountController {

    @Inject
    private AccountService accountService;

    @RequestMapping(value = "/addNewAccount", method = RequestMethod.POST)
    public Account addNewAccount(
            @RequestParam("clientId") Integer clientRefId,
            @RequestParam("putSum") BigDecimal putSum
    ) {
        Account account = new Account();
        account.setClienReftId(clientRefId);
        account.setBalance(putSum);
        return accountService.addNewAccount(account);
    }

    @RequestMapping(value = "/putMoneyOnAccount", method = RequestMethod.POST)
    public Account putMoney(
            @RequestParam("accountId") Integer accountId,
            @RequestParam("putSum") BigDecimal putSum
    ) {
        return accountService.putMoney(accountId, putSum);
    }

    @RequestMapping(value = "/getMoneyFromAccount", method = RequestMethod.POST)
    public Account getMoney(
            @RequestParam("accountId") Integer accountId,
            @RequestParam("getSum") BigDecimal getSum
    ) {
        return accountService.getMoney(accountId, getSum);
    }

    @RequestMapping(value = "/findAccountById", method = RequestMethod.GET)
    public Account findAccountById(
            @RequestParam("accountId") Integer accountId
    ) {
        return accountService.findAccountById(accountId);
    }

    @RequestMapping(value = "/getClientRefId", method = RequestMethod.GET)
    public Integer getClientRefId(
            @RequestParam("accountId") Integer accountId
    ) {
        return accountService.getClientRefId(accountId);
    }

    @RequestMapping(value = "/deleteAccountById", method = RequestMethod.DELETE)
    public void deleteAccountById(
            @RequestParam("accountId") Integer accountId) {
        accountService.deleteAccount(accountId);
    }

}
