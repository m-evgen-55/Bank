package bank.application.service;

import bank.application.dao.ClientDao;
import bank.application.model.Client;
import org.springframework.stereotype.Component;
import javax.inject.Inject;


@Component
public class ClientServiceImpl implements ClientService {

    private final int CLIENT_MIN_AGE = 18;

    @Inject
    private ClientDao clientDao;

    @Override
    public Client addNewClient(final String fio, final int age) {
        if (age >= CLIENT_MIN_AGE) {
            Client client = new Client();
            client.setFIO(fio);
            client.setAge(age);
            return clientDao.insertClient(client);
        }
        // кинуть Exception что клиент не достиг совершеннолетия
        return null;
    }

    @Override
    public Client getClientById(final Integer clientId) {
        Client client = clientDao.getClientById(clientId).orElse(null);
        if (client != null) {
            return client;
        }
        // кинуть Exception что клиент не найден
        return null;
    }

    @Override
    public void deleteClient(final Integer clientId) {
        clientDao.deleteClient(clientId);
    }

}
