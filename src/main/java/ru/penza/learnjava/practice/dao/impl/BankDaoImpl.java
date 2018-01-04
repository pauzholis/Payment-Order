package ru.penza.learnjava.practice.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.penza.learnjava.practice.dao.BankDao;
import ru.penza.learnjava.practice.model.Bank;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Evgeniy on 18.12.2017.
 */
@Repository
public class BankDaoImpl implements BankDao {
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

        em.remove(em.find(Bank.class, id));
    }

    @Override
    public void updateBank(Bank bank)
    {
        em.persist(bank);
    }

    @Override
    public List<Bank> getAllBanks() {
        TypedQuery<Bank> query = em.createQuery("SELECT b FROM Bank b ", Bank.class);
        return query.getResultList();


    }
}
