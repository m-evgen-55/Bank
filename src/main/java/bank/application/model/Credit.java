package bank.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;


@Entity
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer creditId;
    private BigDecimal sumOfCredit;
    private int creditRate;
    private int duration;
    private BigDecimal returnSum;
    private Integer clientRefId;


    public Integer getCreditId() {
        return creditId;
    }

    public BigDecimal getSumOfCredit() {
        return sumOfCredit;
    }

    public void setSumOfCredit(BigDecimal sumOfCredit) {
        this.sumOfCredit = sumOfCredit;
    }

    public int getCreditRate() {
        return creditRate;
    }

    public void setCreditRate(int creditRate) {
        this.creditRate = creditRate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public BigDecimal getReturnSum() {
        return returnSum;
    }

    public void setReturnSum(BigDecimal returnSum) {
        this.returnSum = returnSum;
    }

    public Integer getClientRefId() {
        return clientRefId;
    }

    public void setClientRefId(Integer clientRefId) {
        this.clientRefId = clientRefId;
    }

}
