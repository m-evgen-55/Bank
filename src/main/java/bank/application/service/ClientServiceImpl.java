package bank.application.service;

import bank.application.dao.ClientDao;
import bank.application.exception.ClientException;
import bank.application.model.Client;
import org.springframework.stereotype.Component;
import javax.inject.Inject;


@Component
public class ClientServiceImpl implements ClientService {

    private final int CLIENT_MIN_AGE = 18;

    @Inject
    private ClientDao clientDao;

    @Override
    public Client addNewClient(final String fio, final int age) throws ClientException {
        if (age >= CLIENT_MIN_AGE) {
            Client client = new Client();
            client.setFIO(fio);
            client.setAge(age);
            return clientDao.insertClient(client);
        }
         throw new ClientException("Клиент не достиг совершеннолетия.");
    }

    @Override
    public Client getClientById(final Integer clientId) throws ClientException {
        Client client = clientDao.getClientById(clientId).orElse(null);
        if (client != null) {
            return client;
        }
        throw new ClientException("Клиент не найден.");
    }

    @Override
    public void deleteClient(final Integer clientId) throws ClientException {
        Client client = clientDao.getClientById(clientId).orElse(null);
        if (client != null) {
            clientDao.deleteClient(clientId);
        } else {
            throw new ClientException("Клиент не найден.");
        }
    }

}
