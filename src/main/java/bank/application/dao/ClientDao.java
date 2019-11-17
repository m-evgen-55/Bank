package bank.application.dao;

import bank.application.model.Client;

import java.util.List;
import java.util.Optional;


public interface ClientDao {

    Client insertClient (final Client client);
    Optional<Client> findById(final Integer clientId);
    void updateClient (final Client client);
    void deleteClient(final Client client);
    List getAccountRefId(final String accountId);

}
