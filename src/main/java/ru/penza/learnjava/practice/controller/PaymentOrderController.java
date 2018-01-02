package ru.penza.learnjava.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.penza.learnjava.practice.service.PaymentOrderService;
import ru.penza.learnjava.practice.view.PaymentOrderView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class PaymentOrderController {

    private final PaymentOrderService paymentOrderService;

    @Autowired
    public PaymentOrderController(PaymentOrderService paymentOrderService) {
        this.paymentOrderService = paymentOrderService;
    }

    @RequestMapping(value = "/order", method = {POST})
    public void order(@RequestBody PaymentOrderView paymentOrderView) {
        paymentOrderService.getPaymentOrder(paymentOrderView);
    }

    @RequestMapping(value = "/order", method = {GET})
    public List<PaymentOrderView> orders() {
        return paymentOrderService.getAllOrders();
    }

}
