package ru.penza.learnjava.practice.view;

import java.math.BigInteger;

/**
 * Created by Mihail on 26.12.2017.
 */
public class BankView {

    public Long id;

    public String name;

    public Integer bik;

    public BigInteger account;

    public Integer version;


    //для jackson
    public BankView() {

    }

    public BankView(Long id, String name, Integer bik, BigInteger account, Integer version) {
        this.id = id;
        this.name = name;
        this.bik = bik;
        this.account = account;
        this.version = version;
    }


}
