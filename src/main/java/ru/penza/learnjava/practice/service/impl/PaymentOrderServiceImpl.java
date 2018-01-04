package ru.penza.learnjava.practice.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.penza.learnjava.practice.dao.PaymentOrderDao;
import ru.penza.learnjava.practice.model.PaymentOrder;
import ru.penza.learnjava.practice.service.PaymentOrderService;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import ru.penza.learnjava.practice.view.PaymentOrderView;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Evgeniy on 04.01.2018.
 */
@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class PaymentOrderServiceImpl implements PaymentOrderService{

    private final PaymentOrderDao dao;

    @Autowired
    public PaymentOrderServiceImpl(PaymentOrderDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public PaymentOrderView getPaymentOrder(Long id) {
        PaymentOrder paymentOrder = dao.getPaymentOrderById(id);
        return new PaymentOrderView(paymentOrder.getNumber(),
                paymentOrder.getPaymentOrderDate(), paymentOrder.getAmount());


    }

    @Override
    @Transactional
    public List<PaymentOrderView> getAllOrders() {
        List<PaymentOrder> paymentOrder = dao.getAllPaymentOrder();
        Function<PaymentOrder, PaymentOrderView> mapPaymentOrder = p -> {
            PaymentOrderView paymentOrderView = new PaymentOrderView();
            paymentOrderView.number = p.getNumber();
            paymentOrderView.paymentOrderDate = p.getPaymentOrderDate();
            paymentOrderView.amount = p.getAmount();
            return paymentOrderView;
        };

        return paymentOrder.stream().map(mapPaymentOrder).collect(Collectors.toList());

    }

    @Override
    @Transactional
    public void delete(Long id) {

        dao.deletePaymentOrderById(id);


    }

    @Override
    @Transactional
    public void update(PaymentOrderView view) {
        PaymentOrder paymentOrder = new PaymentOrder(view.number, view.paymentOrderDate,view.amount);
        dao.updatePaymentOrder(paymentOrder);

    }

}
