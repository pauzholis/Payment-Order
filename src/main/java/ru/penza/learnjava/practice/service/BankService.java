package ru.penza.learnjava.practice.service;

import ru.penza.learnjava.practice.view.BankView;
import java.util.List;

public interface BankService {
    BankView getBank(Long id);
    List<BankView> getAllBanks();
    void update(BankView view);
    void delete(Long id);

}
