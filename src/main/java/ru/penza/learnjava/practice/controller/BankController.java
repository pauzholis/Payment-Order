package ru.penza.learnjava.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.penza.learnjava.practice.service.BankService;
import ru.penza.learnjava.practice.view.BankView;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @RequestMapping(value = "/bank/{id}")
    public BankView bank(@PathVariable("id") Long id) {

       return bankService.getBank(id);
    }

    @RequestMapping(value = "/banks", method = {GET})
    public List<BankView> banks() {
        return bankService.getAllBanks();
    }

//    @RequestMapping(value = "/bank", method = {POST})
//    public void update (BankView bankView){
//        bankService.update(bankView);
//    }
//
//    @RequestMapping(value = "/bank", method = {POST})
//    public void delete (Long id){
//        bankService.delete(id);
//    }

}