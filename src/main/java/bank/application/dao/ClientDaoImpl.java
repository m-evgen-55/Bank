package bank.application.dao;

import bank.application.model.Client;
import bank.application.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;


@Component
public class ClientDaoImpl implements ClientDao {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client insertClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> findById(Integer clientId) {
        return clientRepository.findById(clientId);
    }

    @Override
    public void updateClient(Client client) {

    }

    @Override
    public void deleteClient(Client client) {

    }

    @Override
    public List getAccountRefId(String accountId) {
        return null;
    }

}
