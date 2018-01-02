package ru.penza.learnjava.practice.service;

import ru.penza.learnjava.practice.view.PaymentOrderView;

import java.util.List;

public interface PaymentOrderService {


    public void getPaymentOrder(PaymentOrderView paymentOrderView);

    public List<PaymentOrderView> getAllOrders();
}
