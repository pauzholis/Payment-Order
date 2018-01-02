package ru.penza.learnjava.practice.service;

import ru.penza.learnjava.practice.view.BankView;
import ru.penza.learnjava.practice.view.ClientView;

import java.util.List;

/**
 * Created by Evgeniy on 31.12.2017.
 */
public interface BankService {
    void getBank(BankView bankView);
    List<BankView> getAllBanks();
}
