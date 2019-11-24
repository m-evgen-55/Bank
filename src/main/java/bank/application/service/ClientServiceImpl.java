package bank.application.service;

import bank.application.dao.ClientDao;
import bank.application.model.Client;
import org.springframework.stereotype.Component;
import javax.inject.Inject;
import java.util.List;


@Component
public class ClientServiceImpl implements ClientService {

    private final int CLIENT_MIN_AGE = 18;

    @Inject
    private ClientDao clientDao;

    @Override
    public Client addNewClient(final Client client) {
        if (client.getAge() >= CLIENT_MIN_AGE) {
            return clientDao.insertClient(client);
        }
        // сделать Exception
        return null;
    }

    @Override
    public Client getClientById(final Integer clientId) {
        return clientDao.getClientById(clientId).orElse(null);
    }

    @Override
    public void deleteClient(Integer clientId) {
        clientDao.deleteClient(clientId);
    }

//    @Override
//    public List getAccountRefId(String accountId) {
//        return clientDao.getAccountRefId(accountId);
//    }

}
