package ru.penza.learnjava.practice.view;

import java.math.BigInteger;


public class BankView {
    public Long id;
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

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBik() {
        return bik;
    }

    public void setBik(Integer bik) {
        this.bik = bik;
    }

    public BigInteger getAccount() {
        return account;
    }

    public void setAccount(BigInteger account) {
        this.account = account;
    }
}
