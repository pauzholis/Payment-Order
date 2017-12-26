package ru.penza.learnjava.practice.dao.impl;

import ru.penza.learnjava.practice.dao.PaymentOrderDao;
import ru.penza.learnjava.practice.model.Client;
import ru.penza.learnjava.practice.model.PaymentOrder;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Evgeniy on 18.12.2017.
 */
public class PaymentOrderDaoImpl implements PaymentOrderDao{
    public PaymentOrder getPaymentOrderById(Long id) {
        return null;
    }

    public PaymentOrder getPaymentOrderBynumber(BigInteger number) {
        return null;
    }

    public void addPaymentOrder(PaymentOrder paymentOrder) {

    }

    public void deletePaymentOrderById(PaymentOrder paymentOrder) {

    }

    public void updatePaymentOrder(PaymentOrder paymentOrder) {

    }

    public Collection<PaymentOrder> getAllPaymentOrder() {
        return null;
    }

    public Collection<PaymentOrder> getAllPaymentOrderByPayer(Client client) {
        return null;
    }

    public Collection<PaymentOrder> getAllPaymentOrderByDate(Date paymentOrderDate) {
        return null;
    }
}
