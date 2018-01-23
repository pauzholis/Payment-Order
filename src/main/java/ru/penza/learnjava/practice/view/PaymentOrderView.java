package ru.penza.learnjava.practice.view;

import java.math.BigInteger;
import java.util.Date;


public class PaymentOrderView {
    public Long id;
    public BigInteger number;
    public Date paymentOrderDate;
    public BigInteger amount;
    public ClientView payer;
    public ClientView recipient;
    public Long payerId;
    public Long recipientId;

    //для jackson
    public PaymentOrderView() {
    }

    public PaymentOrderView(BigInteger number, Date paymentOrderDate, BigInteger amount,
                            ClientView payer, ClientView recipient) {
        this.number = number;
        this.paymentOrderDate = paymentOrderDate;
        this.amount = amount;
        this.payer = payer;
        this.recipient = recipient;
    }

    public void setPayerId(Long payerId) {
        this.payerId = payerId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    public void setPayer(ClientView payer) {
        this.payer = payer;
    }

    public void setRecipient(ClientView recipient) {
        this.recipient = recipient;
    }

    public void setNumber(BigInteger number) {
        this.number = number;
    }

    public void setPaymentOrderDate(Date paymentOrderDate) {
        this.paymentOrderDate = paymentOrderDate;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public BigInteger getNumber() {return number;}

    public Date getPaymentOrderDate() {
        return paymentOrderDate;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public ClientView getPayer() {
        return payer;
    }

    public ClientView getRecipient() {
        return recipient;
    }

    public Long getPayerId() {
        return payerId;
    }

    public Long getRecipientId() {
        return recipientId;
    }
}


