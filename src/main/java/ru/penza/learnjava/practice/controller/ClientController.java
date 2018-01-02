package ru.penza.learnjava.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.penza.learnjava.practice.service.ClientService;
import ru.penza.learnjava.practice.service.PaymentOrderService;
import ru.penza.learnjava.practice.view.ClientView;
import ru.penza.learnjava.practice.view.PaymentOrderView;

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

    @RequestMapping(value = "/client", method = {POST})
    public void order(@RequestBody ClientView clientView) {
        clientService.getClients(clientView);
    }

    @RequestMapping(value = "/client", method = {GET})
    public List<clientView> clients() {
        return clientService.getAllClients();
    }