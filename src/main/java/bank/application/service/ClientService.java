package bank.application.service;

import bank.application.exception.ClientException;
import bank.application.model.Client;


public interface ClientService {

    Client addNewClient(final String fio, final int age) throws ClientException;
    Client getClientById(final Integer clientId) throws ClientException;
    void deleteClient(final Integer clientId) throws ClientException;

}
