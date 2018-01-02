package ru.penza.learnjava.practice.view;

import java.math.BigInteger;

/**
 * Created by Mihail on 26.12.2017.
 */
public class ClientView {
    public Long id;

    public String name;

    public Long inn;

    public Integer kpp;

    public Integer version;


    //для jackson
    public ClientView() {

    }

    public ClientView(Long id, String name, Integer bik, BigInteger account, Integer version) {
        this.id = id;
        this.name = name;
        this.inn = inn;
        this.kpp = kpp;
        this.version = version;
    }
}
