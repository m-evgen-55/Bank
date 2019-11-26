package bank.application.service;

import bank.application.model.Client;


public interface ClientService {

    Client addNewClient(final String fio, final int age);
    Client getClientById(final Integer clientId);
    void deleteClient(final Integer clientId);

}
