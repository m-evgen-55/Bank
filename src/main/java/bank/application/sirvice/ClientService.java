package bank.application.sirvice;

import bank.application.model.Client;

import java.util.List;
import java.util.Optional;


public interface ClientService {

    Client addNewClient(Client client);
    Optional<Client> getClient(Integer clientId);
    List getAccountRefId(String accountId);

}
