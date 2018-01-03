package ru.penza.learnjava.practice.view;

import java.math.BigInteger;

/**
 * Created by Mihail on 26.12.2017.
 */
public class ClientView {


    public String name;

    public BigInteger account;

    public Long inn;

    public Integer kpp;

    public Integer version;


    //для jackson
    public ClientView() {

    }

    public ClientView( String name,BigInteger account, Long inn, Integer kpp) {

        this.name = name;
        this.account = account;
        this.inn = inn;
        this.kpp = kpp;

    }
}
