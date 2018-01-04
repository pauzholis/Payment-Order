package ru.penza.learnjava.practice.view;

import java.math.BigInteger;


public class BankView {



    public String name;

    public Integer bik;

    public BigInteger account;




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
