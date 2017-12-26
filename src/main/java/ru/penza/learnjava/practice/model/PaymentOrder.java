package ru.penza.learnjava.practice.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

/**
 * Платежные поручения
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_payer")
    private Client payer;

    /**
     * Получатель
     */
    @ManyToOne(fetch = FetchType.LAZY)
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
