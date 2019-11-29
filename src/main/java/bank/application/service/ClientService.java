package bank.application.service;

import bank.application.exception.ClientException;
import bank.application.model.Account;
import bank.application.model.Client;
import bank.application.model.Credit;
import java.util.List;


public interface ClientService {

    Client addNewClient(final String fio, final int age) throws ClientException;
    Client getClientById(final Integer clientId) throws ClientException;
    void deleteClient(final Integer clientId) throws ClientException;
    List<Account> getAllClientAccounts(final Integer clientId);
    List<Credit> getAllClientCredits(final Integer clientId);

}

