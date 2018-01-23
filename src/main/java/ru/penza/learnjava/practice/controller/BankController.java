package ru.penza.learnjava.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.penza.learnjava.practice.service.BankService;
import ru.penza.learnjava.practice.view.BankView;
import java.math.BigInteger;


@Controller
@RequestMapping(value = "/")
public class BankController {
    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @RequestMapping(value = "bank/{id}")
    public BankView bank(@PathVariable("id") Long id) {
        return bankService.getBank(id);
    }

    @RequestMapping("bank")
    public String getAllBanks (Model model){
        model.addAttribute("bankView",bankService.getAllBanks());
        return "bank";
    }

    @RequestMapping(value = { "bank/addBank" })
    public String showAddBankPage(Model model) {
        model.addAttribute("bankView", new BankView());
        return "addBank";
    }

    @RequestMapping(value = "bank/addBank/submit", method = RequestMethod.POST)
    public String update (@ModelAttribute BankView bankView ){
        String name = bankView.getName();
        Integer bik = bankView.getBik();
        BigInteger account = bankView.getAccount();
        BankView newBank = new BankView (name,bik,account);
        bankService.update(newBank);
        return "redirect:/bank";
}

    @RequestMapping(value = "bank/delete/{id}")
    public String delete (@PathVariable("id") Long id){
        bankService.delete(id);
        return "redirect:../";
    }
}