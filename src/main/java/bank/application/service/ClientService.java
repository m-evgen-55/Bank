package bank.application.service;

import bank.application.model.Client;

import java.util.List;


public interface ClientService {

    Client addNewClient(Client client);
    Client getClientById(Integer clientId);
    void deleteClient(Integer clientId);
//    List getAccountRefId(String accountId);

}
