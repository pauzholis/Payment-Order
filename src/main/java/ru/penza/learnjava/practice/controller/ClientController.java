package ru.penza.learnjava.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.penza.learnjava.practice.service.ClientService;
import ru.penza.learnjava.practice.view.ClientView;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/client/{id}")
    public ClientView client(@PathVariable ("id")  Long id) {

        return clientService.getClient(id);
    }

    @RequestMapping(value = "/clients", method = {GET})
    public List<ClientView> clients() {
        return clientService.getAllClients();
    }
//    @RequestMapping(value = "/client", method = {POST})
//    public void update (ClientView clientView){
//        clientService.update(clientView);
//    }
//
//    @RequestMapping(value = "/client", method = {POST})
//    public void delete (Long id){
//        clientService.delete(id);
//    }


}