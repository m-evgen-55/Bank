package bank.application.dao;

import bank.application.model.Credit;
import java.util.Optional;


public interface CreditDao {

    Credit insertCredit(final Credit credit);
    Optional<Credit> findCreditById(final Integer creditId);
    void deleteCredit(final Integer creditId);

}
