package bank.application.controller;

import bank.application.model.Client;
import bank.application.service.ClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.inject.Inject;


@RestController
public class ClientController {

    @Inject
    private ClientService clientService;

    @RequestMapping(value = "/addNewClient", method = RequestMethod.POST)
    public Client addNewClient(
            @RequestParam("fio") String fio,
            @RequestParam("age") int age) {
        Client client = new Client();
        client.setFIO(fio);
        client.setAge(age);
        return clientService.addNewClient(client);
    }

    // не работает
    @RequestMapping(value = "/getClientById", method = RequestMethod.GET)
    public Client getClientById(
            @RequestParam("clientId") Integer clientId) {
        return clientService.getClientById(clientId);
        // попробовать создать объект клиента
    }

    // не работает
    @RequestMapping(value = "/deleteClientById", method = RequestMethod.DELETE)
    public void deleteClientById(
            @RequestParam("clientId") Integer clientId) {
        clientService.deleteClient(clientId);
    }

    // добавить метод, который возвращает список всех аккаунтов клиента

    // добавить метод, который возвращает список всех кредитов клиента

}
