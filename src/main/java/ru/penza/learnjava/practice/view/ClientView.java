package ru.penza.learnjava.practice.view;

import java.math.BigInteger;

public class ClientView {
    public Long id;
    public String name;
    public BigInteger account;
    public Long inn;
    public Integer kpp;

    //для jackson
    public ClientView() {
    }
    public ClientView(String name, BigInteger account, Long inn, Integer kpp) {
        this.name = name;
        this.account = account;
        this.inn = inn;
        this.kpp = kpp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccount(BigInteger account) {
        this.account = account;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public void setKpp(Integer kpp) {
        this.kpp = kpp;
    }

    public String getName() {
        return name;
    }

    public BigInteger getAccount() {
        return account;
    }

    public Long getInn() {
        return inn;
    }

    public Integer getKpp() {
        return kpp;
    }
}
