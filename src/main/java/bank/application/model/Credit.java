package bank.application.model;

import org.omg.CORBA.PRIVATE_MEMBER;


public class Credit {

    private String creditId;
    private int sunOfCredit;
    private int creditRate;
    private int duration;
    private int clientRefId;

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public int getSunOfCredit() {
        return sunOfCredit;
    }

    public void setSunOfCredit(int sunOfCredit) {
        this.sunOfCredit = sunOfCredit;
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

    public int getClientRefId() {
        return clientRefId;
    }

    public void setClientRefId(int clientRefId) {
        this.clientRefId = clientRefId;
    }

}
