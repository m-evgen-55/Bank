package bank.application.controller;

import bank.application.exception.ClientException;
import bank.application.model.Account;
import bank.application.model.Client;
import bank.application.model.Credit;
import bank.application.service.ClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.inject.Inject;
import java.util.List;


@RestController
public class ClientController {

    @Inject
    private ClientService clientService;


    @RequestMapping(value = "/addNewClient", method = RequestMethod.POST)
    public Client addNewClient(
            @RequestParam("fio") String fio,
            @RequestParam("age") int age) throws ClientException {
            return clientService.addNewClient(fio, age);
    }

    // Вопрос: обязательное ли использовать Integer для id? Почему не int?
    @RequestMapping(value = "/getClientById", method = RequestMethod.GET)
    public Client getClientById(
            @RequestParam("clientId") Integer clientId) throws ClientException {
        return clientService.getClientById(clientId);
    }
    
    @RequestMapping(value = "/deleteClientById", method = RequestMethod.DELETE)
    public void deleteClientById(
            @RequestParam("clientId") Integer clientId) throws ClientException {
        clientService.deleteClient(clientId);
    }

    @RequestMapping(value = "/getClientAccounts", method = RequestMethod.GET)
    public List<Account> getClientAccounts(
            @RequestParam("clientId") Integer clientId) {
        return clientService.getAllClientAccounts(clientId);
    }

    @RequestMapping(value = "/getClientCredits", method = RequestMethod.GET)
    public List<Credit> getClientCredits(
            @RequestParam("clientId") Integer clientId) {
        return clientService.getAllClientCredits(clientId);
    }

}
