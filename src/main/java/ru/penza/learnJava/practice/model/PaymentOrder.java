package ru.penza.learnJava.practice.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Mihail on 16.12.2017.
 */
@Entity
@Table(name = "payment_order")

public class PaymentOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Идентификатор записи
     */

    @Basic(optional = false)
    @Column(name = "number")
    private BigInteger number;

    /**
     * Номер платежного поручения
     */

    @Basic(optional = false)
    @Column(name = "payment_order_date")
    @Temporal(value = TemporalType.DATE)
    private Date paymentOrderDate;

    /**
     * Дата создания платежного поручения
     */

    @Basic(optional = false)
    @Column(name = "amount")
    private BigInteger amount;


    /**
     * Служебное поле hibernate
     */

    @Version
    private Integer version;

    /**
     * Плательщик
     */

    @ManyToOne
    @JoinColumn(name = "id_payer")
    private Client payer;

    /**
     * Получатель
     */

    @ManyToOne
    @JoinColumn(name = "id_recipient")
    private Client recipient;


    public PaymentOrder() {
    }

    public PaymentOrder(BigInteger number, Date paymentOrderDate,
                        BigInteger amount, Client payer, Client recipient) {
        this.number = number;
        this.paymentOrderDate = paymentOrderDate;
        this.amount = amount;
        this.payer = payer;
        this.recipient = recipient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getNumber() {
        return number;
    }

    public void setNumber(BigInteger number) {
        this.number = number;
    }

    public Date getPaymentOrderDate() {
        return paymentOrderDate;
    }

    public void setPaymentOrderDate(Date paymentOrderDate) {
        this.paymentOrderDate = paymentOrderDate;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Client getPayer() {
        return payer;
    }

    public void setPayer(Client payer) {
        this.payer = payer;
    }

    public Client getRecipient() {
        return recipient;
    }

    public void setRecipient(Client recipient) {
        this.recipient = recipient;
    }
}
