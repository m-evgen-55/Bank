package bank.application.repository;

import bank.application.model.Client;
import org.springframework.data.repository.CrudRepository;


public interface ClientRepository extends CrudRepository<Client, Integer> {
}
