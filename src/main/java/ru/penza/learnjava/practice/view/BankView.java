package ru.penza.learnjava.practice.view;

import java.math.BigInteger;

/**
 * Created by Mihail on 26.12.2017.
 */
public class BankView {



    public String name;

    public Integer bik;

    public BigInteger account;

    public Integer version;


    //для jackson
    public BankView() {

    }

    public BankView( String name, Integer bik, BigInteger account) {

        this.name = name;
        this.bik = bik;
        this.account = account;

    }

    public String toString(){
        return "{name:" + name + ";bik:" + bik + ";account" + account + "}";
    }


}
