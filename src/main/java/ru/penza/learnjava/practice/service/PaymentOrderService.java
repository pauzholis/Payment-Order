package ru.penza.learnjava.practice.service;

import ru.penza.learnjava.practice.view.PaymentOrderView;

import java.util.List;

public interface PaymentOrderService {


    PaymentOrderView getPaymentOrder(Long id);
    List<PaymentOrderView> getAllOrders();
    void delete (PaymentOrderView view);
    void update (PaymentOrderView view);
    void add(PaymentOrderView view);

}
