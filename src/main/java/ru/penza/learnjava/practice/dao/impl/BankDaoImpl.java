package ru.penza.learnjava.practice.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.penza.learnjava.practice.dao.BankDao;
import ru.penza.learnjava.practice.model.Bank;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BankDaoImpl implements BankDao {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BankDaoImpl.class);
    private final EntityManager em;

    @Autowired
    public BankDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Bank getBankById(Long id) {
        return em.find(Bank.class, id);
    }

    @Override
    public void deleteBank(Long id) {
        Bank bank = em.find(Bank.class,id);
        if (bank != null)
        em.remove(bank);
        logger.info("Bank delete as " + bank);
    }

    @Override
    public void updateBank(Bank bank) {
        Bank newBank = em.merge(bank);
        em.persist(newBank);
    }

    @Override
    public List<Bank> getAllBanks() {
        TypedQuery<Bank> query = em.createQuery("SELECT b FROM Bank b ", Bank.class);
        return query.getResultList();
    }
}
