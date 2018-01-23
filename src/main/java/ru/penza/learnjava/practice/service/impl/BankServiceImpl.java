package ru.penza.learnjava.practice.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.penza.learnjava.practice.dao.BankDao;
import ru.penza.learnjava.practice.model.Bank;
import ru.penza.learnjava.practice.service.BankService;
import ru.penza.learnjava.practice.view.BankView;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class BankServiceImpl implements BankService {
    private final BankDao dao;

    @Autowired
    public BankServiceImpl(BankDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public BankView getBank(Long id) {
        Bank bank = dao.getBankById(id);
        return new BankView(bank.getName(), bank.getBik(), bank.getAccount());
    }

    @Override
    @Transactional
    public List<BankView> getAllBanks() {
        List<Bank> banks = dao.getAllBanks();
        Function<Bank, BankView> mapBank = b -> {
            BankView bankView = new BankView();
            bankView.id = b.getId();
            bankView.name = b.getName();
            bankView.bik = b.getBik();
            bankView.account = b.getAccount();
            return bankView;
        };
        return banks.stream().map(mapBank).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void update(BankView view) {
        Bank bank = new Bank(view.getName(), view.getBik(), view.getAccount());
        dao.updateBank(bank);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.deleteBank(id);
    }
}

