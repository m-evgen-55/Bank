package bank.application.service;

import bank.application.model.Client;


public interface ClientService {

    Client addNewClient(final Client client);
    Client getClientById(final Integer clientId);
    void deleteClient(final Integer clientId);

}
