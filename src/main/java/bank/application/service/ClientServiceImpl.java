package bank.application.service;

import bank.application.dao.AccountDao;
import bank.application.dao.ClientDao;
import bank.application.dao.CreditDao;
import bank.application.exception.ClientException;
import bank.application.model.Account;
import bank.application.model.Client;
import bank.application.model.Credit;
import org.springframework.stereotype.Component;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


@Component
public class ClientServiceImpl implements ClientService {

    private final int CLIENT_MIN_AGE = 18;

    @Inject
    private ClientDao clientDao;

    @Inject
    private AccountDao accountDao;

    @Inject
    private CreditDao creditDao;


    // в методе осуществляется проверка что клиенту больше 18 лет
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

    // в методе осуществляется проверка то, что у клиента нет не погашенных кредитов
    // нельзя удалить клиента с непогашенными кредитами
    // при удалении клиента, так же удаляются все свзанные аккаунты и кредиты
    @Override
    public void deleteClient(final Integer clientId) throws ClientException {
        Client client = clientDao.getClientById(clientId).orElse(null);
        ArrayList<Credit> clientCredits = (ArrayList<Credit>) getAllClientCredits(clientId);
        ArrayList<Credit> clientNotPaidCredits = new ArrayList<>();
        if (clientCredits.size() > 0) {
            for (int i = 0; i < clientCredits.size(); i++) {
                if (!clientCredits.get(i).isPaidOff()) {
                    clientNotPaidCredits.add(clientCredits.get(i));
                }
            }
        }
        if (client != null) {
            if (clientNotPaidCredits.size() == 0) {
                clientDao.deleteClient(clientId);
                ArrayList<Account> clientAccounts = (ArrayList<Account>) getAllClientAccounts(clientId);
                for (int i = 0; i < clientAccounts.size(); i++) {
                    Integer accountId = clientAccounts.get(i).getAccountId();
                    accountDao.deleteAccount(accountId);
                }
                for (int i = 0; i < clientCredits.size(); i++) {
                    Integer creditId = clientCredits.get(i).getCreditId();
                    creditDao.deleteCredit(creditId);
                }
            } else {
                throw new ClientException("Клиента нельзя удалить. У клиента имеются непогашенные кредиты.");
            }
        } else {
            throw new ClientException("Клиент не найден.");
        }
    }

    @Override
    public List<Account> getAllClientAccounts(Integer clientId) {
        ArrayList<Account> clientAccounts = new ArrayList<>();
        ArrayList<Account> allAccounts = accountDao.getAllAccounts();
        for (int i = 0; i < allAccounts.size(); i++) {
            if (allAccounts.get(i).getClienReftId().equals(clientId)) {
                clientAccounts.add(allAccounts.get(i));
            }
        }
        return clientAccounts;
    }

    @Override
    public List<Credit> getAllClientCredits(Integer clientId) {
        ArrayList<Credit> clientCredits = new ArrayList<>();
        ArrayList<Credit> allCredits = creditDao.getAllCredits();
        for (int i = 0; i < allCredits.size(); i++) {
            if (allCredits.get(i).getClientRefId().equals(clientId)) {
                clientCredits.add(allCredits.get(i));
            }
        }
        return clientCredits;
    }

}
