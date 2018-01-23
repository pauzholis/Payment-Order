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
import ru.penza.learnjava.practice.view.ClientView;
import ru.penza.learnjava.practice.view.PaymentOrderView;
import java.util.List;
import java.util.stream.Collectors;


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
        ClientView payer = new ClientView(paymentOrder.getPayer().getName(),paymentOrder.getPayer().getAccount(),
                paymentOrder.getPayer().getInn(), paymentOrder.getPayer().getKpp());
        ClientView recipient = new ClientView(paymentOrder.getRecipient().getName(),
                paymentOrder.getRecipient().getAccount(),paymentOrder.getRecipient().getInn(),
                paymentOrder.getRecipient().getKpp());
        return new PaymentOrderView(paymentOrder.getNumber(),
                paymentOrder.getPaymentOrderDate(), paymentOrder.getAmount(), payer,recipient);
    }

    @Override
    @Transactional
    public List<PaymentOrderView> getAllOrders() {
        List<PaymentOrder> paymentOrder = dao.getAllPaymentOrder();
        Function<PaymentOrder, PaymentOrderView> mapPaymentOrder = p -> {
            PaymentOrderView paymentOrderView = new PaymentOrderView();
            paymentOrderView.id = p.getId();
            paymentOrderView.number = p.getNumber();
            paymentOrderView.paymentOrderDate = p.getPaymentOrderDate();
            paymentOrderView.amount = p.getAmount();
            paymentOrderView.payer = new ClientView(p.getPayer().getName(),p.getPayer().getAccount(),
                    p.getPayer().getInn(), p.getPayer().getKpp());
            paymentOrderView.recipient =new ClientView(p.getPayer().getName(),p.getPayer().getAccount(),
                    p.getPayer().getInn(), p.getPayer().getKpp());
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
