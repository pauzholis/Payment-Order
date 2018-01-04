package ru.penza.learnjava.practice.view;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Mihail on 26.12.2017.
 */
public class PaymentOrderView {


    public BigInteger number;

    public Date paymentOrderDate;

    public BigInteger amount;




    //для jackson
    public PaymentOrderView() {

    }

    public PaymentOrderView(BigInteger number, Date paymentOrderDate, BigInteger amount) {
        this.number = number;
        this.paymentOrderDate = paymentOrderDate;
        this.amount = amount;

    }
}


