package bank.application.dao;

import bank.application.model.Client;

import java.util.List;


public interface ClientDao {

    Client insertClient (final Client client);
    void updateClient (final Client client);
    void deleteClient(final Client client);
    Client findById(final String id);
    List getAccountRefId(final String accountId);

}
