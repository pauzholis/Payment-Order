package ru.penza.learnjava.practice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.penza.learnjava.practice.model.Bank;
import ru.penza.learnjava.practice.service.BankService;
import ru.penza.learnjava.practice.view.BankView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class BankServiceImpl implements BankService {
    private final Logger log = LoggerFactory.getLogger(BankServiceImpl.class);

    private final BankDAO dao;

    @Autowired
    public BankServiceImpl(BankDAO dao) {
        this.dao = dao;
    }


    @Override
    @Transactional
    public BankView getBank(Long id) {
return dao.getById(id);
    }

    @Override
    public List<BankView> getAllBanks() {
        return null;
    }
}
}
