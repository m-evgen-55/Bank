package bank.application.repository;

import bank.application.model.Credit;
import org.springframework.data.repository.CrudRepository;


public interface CreditRepository extends CrudRepository<Credit, Integer> {
}
