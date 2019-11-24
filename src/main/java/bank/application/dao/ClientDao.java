package bank.application.dao;

import bank.application.model.Client;


public interface ClientDao {

    Client insertClient (final Client client);
    Client getClientById(final Integer clientId);
    void deleteClient(final Integer clientId);

}
