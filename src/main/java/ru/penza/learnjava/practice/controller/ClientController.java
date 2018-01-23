package ru.penza.learnjava.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.penza.learnjava.practice.service.ClientService;
import ru.penza.learnjava.practice.view.ClientView;
import java.math.BigInteger;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Controller
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "client/{id}")
    public ClientView client(@PathVariable ("id")  Long id) {
        return clientService.getClient(id);
    }

    @RequestMapping("client")
    public String getAllClients(Model model) {
        model.addAttribute("clientView",clientService.getAllClients());
        return "client";
    }
    @RequestMapping(value = { "client/addClient" })
    public String showAddClientPage(Model model) {
        model.addAttribute("clientView", new ClientView());
        return "addClient";
    }
    @RequestMapping(value = "client/addClient/submit", method = RequestMethod.POST)
    public String update (@ModelAttribute ClientView clientView ){
        String name = clientView.getName();
        BigInteger account = clientView.getAccount();
        Long inn = clientView.getInn();
        Integer kpp = clientView.getKpp();
        ClientView newClient = new ClientView (name,account,inn,kpp);
        clientService.update(newClient );
        return "redirect:/client";
    }
    @RequestMapping(value = "client/delete/{id}")
    public String delete (@PathVariable("id") Long id){
        clientService.delete(id);
        return "redirect:../";
    }
}