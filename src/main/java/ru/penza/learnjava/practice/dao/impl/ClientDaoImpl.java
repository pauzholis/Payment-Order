package ru.penza.learnjava.practice.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.penza.learnjava.practice.dao.ClientDao;
import ru.penza.learnjava.practice.model.Client;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {
    private final EntityManager em;

    @Autowired
    public ClientDaoImpl(EntityManager em) {

        this.em = em;
    }

    @Override
    public Client getClientById(Long id) {

        return em.find(Client.class, id);
    }

    @Override
    public void deleteClient(Long id) {
        em.remove(em.find(Client.class, id));
    }

    @Override
    public void updateClient(Client client) {
        em.persist(client);
    }

    @Override
    public List<Client> getAllClient() {
        TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c", Client.class);
        return query.getResultList();
    }
}
