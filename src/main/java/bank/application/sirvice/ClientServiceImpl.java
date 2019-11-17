package bank.application.sirvice;

import bank.application.dao.ClientDao;
import bank.application.model.Client;
import org.springframework.stereotype.Component;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;


@Component
public class ClientServiceImpl implements ClientService {

    @Inject
    private ClientDao clientDao;

    @Override
    public Client addNewClient(final Client client) {
        return clientDao.insertClient(client);
    }

    @Override
    public Optional<Client> getClient(final Integer clientId) {
        return clientDao.findById(clientId);
    }

    @Override
    public List getAccountRefId(String accountId) {
        return clientDao.getAccountRefId(accountId);
    }

}
