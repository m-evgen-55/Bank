package bank.application.dao;

import bank.application.model.Client;

import java.util.Optional;


public interface ClientDao {

    Client insertClient (final Client client);
    Optional<Client> getClientById(final Integer clientId);
    void deleteClient(final Integer clientId);

}
