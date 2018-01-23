package ru.penza.learnjava.practice.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.penza.learnjava.practice.dao.PaymentOrderDao;
import ru.penza.learnjava.practice.model.PaymentOrder;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigInteger;
import java.util.List;

@Repository
public class PaymentOrderDaoImpl implements PaymentOrderDao {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PaymentOrderDaoImpl.class);
    private final EntityManager em;

    @Autowired
    public PaymentOrderDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public PaymentOrder getPaymentOrderById(Long id) {
        return em.find(PaymentOrder.class, id);
    }

    @Override
    public PaymentOrder getPaymentOrderByNumber(BigInteger number) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<PaymentOrder> criteria = builder.createQuery(PaymentOrder.class);

        Root<PaymentOrder> person = criteria.from(PaymentOrder.class);
        criteria.where(builder.equal(person.get("number"), number));

        TypedQuery<PaymentOrder> query = em.createQuery(criteria);
        return query.getSingleResult();
    }

    @Override
    public void deletePaymentOrderById(Long id) {
        PaymentOrder paymentOrder = em.find(PaymentOrder.class, id);
        if (paymentOrder != null)
        em.remove(paymentOrder);
    }

    @Override
    public void updatePaymentOrder(PaymentOrder paymentOrder) {
        em.persist(paymentOrder);
    }

    @Override
    public List<PaymentOrder> getAllPaymentOrder() {
        TypedQuery<PaymentOrder> query = em.createQuery("SELECT p FROM PaymentOrder p", PaymentOrder.class);
        return query.getResultList();
    }
}
