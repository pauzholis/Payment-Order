package ru.penza.learnjava.practice.view;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Mihail on 26.12.2017.
 */
public class PaymentOrderView {
    public Long id;

    public BigInteger number;

    public Date paymentOrderDate;

    public BigInteger amount;

    public Integer version;


    //для jackson
    public PaymentOrderView() {

    }

    public PaymentOrderView(Long id, String name, Integer bik, BigInteger account, Integer version) {
        this.id = id;
        this.number = number;
        this.paymentOrderDate = paymentOrderDate;
        this.amount = amount;
        this.version = version;
    }

}
