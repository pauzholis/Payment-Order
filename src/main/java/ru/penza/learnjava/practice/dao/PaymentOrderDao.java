package ru.penza.learnjava.practice.dao;

import ru.penza.learnjava.practice.model.Client;
import ru.penza.learnjava.practice.model.PaymentOrder;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Evgeniy on 17.12.2017.
 */
public interface PaymentOrderDao {

    /**
     * Получение платежного поручения по идентификатору
     */
    public PaymentOrder getPaymentOrderById(Long id);

    /**
     * Получение платежного поручения по номеру
     */
    public PaymentOrder getPaymentOrderBynumber(BigInteger number);

    /**
     * Добавление платежного поручения
     */
    public void addPaymentOrder (PaymentOrder paymentOrder);

    /**
     * Удаление платежного поручения по идентификатору
     */
    public void deletePaymentOrderById (PaymentOrder paymentOrder);

    /**
     * Редактирование платежного поручения
     */
    public void updatePaymentOrder(PaymentOrder paymentOrder);

    /**
     * Получение всех платежных поручений
     */
    public Collection<PaymentOrder> getAllPaymentOrder();

    /**
     * Получение всех платежных поручений по плательщику
     */
    public Collection<PaymentOrder> getAllPaymentOrderByPayer(Client client);

    /**
     * Получение всех платежных поручений по дате
     */
    public Collection<PaymentOrder> getAllPaymentOrderByDate(Date paymentOrderDate);
}
