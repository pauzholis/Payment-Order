package ru.penza.learnjava.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.penza.learnjava.practice.service.ClientService;
import ru.penza.learnjava.practice.service.PaymentOrderService;
import ru.penza.learnjava.practice.view.ClientView;
import ru.penza.learnjava.practice.view.PaymentOrderView;
import java.math.BigInteger;
import java.util.Date;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/")
public class PaymentOrderController {
    private final PaymentOrderService paymentOrderService;
    private final ClientService clientService;

    @Autowired
    public PaymentOrderController(PaymentOrderService paymentOrderService, ClientService clientService) {
        this.paymentOrderService = paymentOrderService;
        this.clientService = clientService;
    }

    @RequestMapping(value = "order/{id}")
    public PaymentOrderView order(@PathVariable("id") Long id) {
       return  paymentOrderService.getPaymentOrder(id);
    }

    @RequestMapping(value = "order")
    public String orders(Model model) {
        model.addAttribute("paymentOrderView",paymentOrderService.getAllOrders());
        return "order";
    }

    @RequestMapping(value = "order/addOrder")
    public String addPaymentOrder(Model model) {
      model.addAttribute("paymentOrderView", new PaymentOrderView());
        return "addOrder";
    }

    @RequestMapping(value = "order/addOrder/submit", method = POST)
    public String submitChange(@ModelAttribute PaymentOrderView paymentOrderView){
        BigInteger number = paymentOrderView.number;
        Date paymentOrderDate = paymentOrderView.paymentOrderDate;
        BigInteger amount = paymentOrderView.amount;
        ClientView payer = clientService.getClient(paymentOrderView.payerId);
        ClientView recipient = clientService.getClient(paymentOrderView.recipientId);
        PaymentOrderView newPaymentOrder = new PaymentOrderView(number,paymentOrderDate,amount,payer,recipient);
        paymentOrderService.update(newPaymentOrder);
        return "redirect:/order";
    }


    @RequestMapping(value = "/orders/delete/{id}")
    public String delete (@PathVariable("id") Long id){
        paymentOrderService.delete(id);
        return "redirect:../";
    }
}
