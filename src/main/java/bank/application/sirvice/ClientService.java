package bank.application.sirvice;

import bank.application.model.Client;

import java.util.List;


public interface ClientService {

    Client addNewClient(Client client);
    Client getClient(String clientId);
    List getAccountRefId(String accountId);

}
