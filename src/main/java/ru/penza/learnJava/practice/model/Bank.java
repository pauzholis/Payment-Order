package ru.penza.learnJava.practice.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mihail on 16.12.2017.
 */
@Entity
@Table(name = "bank")

public class Bank {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
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
    private Set<Client>client = new HashSet<Client>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
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

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Set<Client> getClient() {
        return client;
    }

    public void setClient(Set<Client> client) {
        this.client = client;
    }
}

