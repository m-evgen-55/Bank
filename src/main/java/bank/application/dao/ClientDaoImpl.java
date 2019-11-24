package bank.application.dao;

import bank.application.model.Client;
import bank.application.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ClientDaoImpl implements ClientDao {

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public Client insertClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(Integer clientId) {
        Client client = clientRepository.findById(clientId).orElse(null);
        // если client == null, кинуть Exception что клиент не найден
        return client;
    }

    @Override
    public void deleteClient(Integer clientId) {
        clientRepository.deleteById(clientId);
    }

}
