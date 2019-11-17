package bank.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;


@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer clientID;
    private String FIO;
    private int age;
    //private List<Account> accounts;
    //private List<Credit> credits;

    public Integer getClientId() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public List<Account> getAccounts() {
//        return accounts;
//    }

//    public void setAccounts(List<Account> accounts) {
//        this.accounts = accounts;
//    }

//    public List<Credit> getCredits() {
//        return credits;
//    }

//    public void setCredits(List<Credit> credits) {
//        this.credits = credits;
//    }

}
