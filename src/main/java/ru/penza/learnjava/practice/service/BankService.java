package ru.penza.learnjava.practice.service;

import ru.penza.learnjava.practice.model.Bank;
import ru.penza.learnjava.practice.view.BankView;
import ru.penza.learnjava.practice.view.ClientView;

import java.util.List;


public interface BankService {
    BankView getBank(Long id);
    List<BankView> getAllBanks();
    void update(BankView view);
    void delete(BankView view);

}
