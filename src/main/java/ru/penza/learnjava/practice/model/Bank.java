package ru.penza.learnjava.practice.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Банки
 */
@Entity
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * Наименование банка
     */
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    /**
     * БИК банка
     */
    @Column(name = "bik")
    private Integer bik;

    /**
     * Номер счета банка
     */
    @Basic(optional = false)
    @Column(name = "account")
    private BigInteger account;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Перечень клиентов банка
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bank")
    private Set<Client> client = new HashSet<Client>();

    public String getName() {
        return name;
    }

    public Bank(String name, Integer bik, BigInteger account) {
        this.name = name;
        this.bik = bik;
        this.account = account;

    }

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

    public Integer getVersion() {
        return version;
    }

    public Set<Client> getClient() {
        return client;
    }

    public void setClient(Set<Client> client) {
        this.client = client;
    }
}

