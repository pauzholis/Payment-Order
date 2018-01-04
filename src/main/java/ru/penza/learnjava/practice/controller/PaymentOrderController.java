package ru.penza.learnjava.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/order/{id}")
    public PaymentOrderView order(@PathVariable("id") Long id) {
       return  paymentOrderService.getPaymentOrder(id);
    }

    @RequestMapping(value = "/orders", method = {GET})
    public List<PaymentOrderView> orders() {

        return paymentOrderService.getAllOrders();
    }

//    @RequestMapping(value = "/order", method = {POST})
//    public void update(PaymentOrderView paymentOrderView) {
//        paymentOrderService.update(paymentOrderView);
//    }
//
//    @RequestMapping(value = "/order", method = {POST})
//    public void delete(Long id) {
//        paymentOrderService.delete(id);
//    }




}
