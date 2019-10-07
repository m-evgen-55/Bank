package bank.application.controller;

import bank.application.model.Account;
import bank.application.model.Client;
import bank.application.sirvice.AccountService;
import bank.application.sirvice.ClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.inject.Inject;
import java.util.UUID;


@RestController
public class ClientController {

    @Inject
    private ClientService clientService;

    @RequestMapping(value = "/addNewClient", method = RequestMethod.POST)
    public void addNewClient(
            @RequestParam("fio") String fio,
            @RequestParam("age") int age
    ) {
        clientService.addNewClient(toClient(fio, age));
    }


    private static Client toClient(String fio, int age) {
        Client client = new Client();
        client.setClientID(UUID.randomUUID().toString());
        client.setFIO(fio);
        client.setAge(age);
        return client;
    }

}
