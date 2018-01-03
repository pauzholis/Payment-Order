package ru.penza.learnjava.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.penza.learnjava.practice.service.BankService;
import ru.penza.learnjava.practice.service.ClientService;
import ru.penza.learnjava.practice.view.BankView;
import ru.penza.learnjava.practice.view.ClientView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(ClientService clientService) {
        this.bankService = bankService;
    }

    @RequestMapping(value = "/bank", method = {POST})
    public void bank(@RequestBody BankView bankView) {
        bankService.getBank(bankView);
    }

    @RequestMapping(value = "/bank", method = {GET})
    public List<bankView> banks() {
        return bankService.getAllBanks();
    }
}