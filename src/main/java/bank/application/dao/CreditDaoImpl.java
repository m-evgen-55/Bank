package bank.application.dao;

import bank.application.model.Credit;
import bank.application.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Optional;


@Component
public class CreditDaoImpl implements CreditDao {

    @Autowired
    private CreditRepository creditRepository;


    @Override
    public Credit insertCredit(Credit credit) {
        return creditRepository.save(credit);
    }

    @Override
    public Optional<Credit> findCreditById(Integer creditId) {
        return creditRepository.findById(creditId);
    }

    @Override
    public void deleteCredit(Integer creditId) {
        creditRepository.deleteById(creditId);
    }

    @Override
    public ArrayList<Credit> getAllCredits() {
        ArrayList<Credit> allCredits = (ArrayList<Credit>) creditRepository.findAll();
        return allCredits;
    }

}
