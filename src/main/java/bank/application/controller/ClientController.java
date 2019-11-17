package bank.application.controller;

import bank.application.model.Client;
import bank.application.sirvice.ClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.inject.Inject;
import java.util.Optional;


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

    // избавиться от optional
    @RequestMapping(value = "/getClientById", method = RequestMethod.GET)
    public Optional<Client> getClientById(
            @RequestParam("clientId") Integer clientId) {
        return clientService.getClient(clientId);
    }

}
