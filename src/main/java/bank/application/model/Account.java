package bank.application.model;

import java.math.BigDecimal;


public class Account {

    private String accountId;
    private BigDecimal balance;
    private String clienReftId;

    // clientId

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getClienReftId() {
        return clienReftId;
    }

    public void setClienReftId(String clienReftId) {
        this.clienReftId = clienReftId;
    }

}
