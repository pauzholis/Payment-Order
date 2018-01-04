package ru.penza.learnjava.practice.dao;

import ru.penza.learnjava.practice.model.PaymentOrder;

import java.math.BigInteger;
import java.util.List;

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
    public PaymentOrder getPaymentOrderByNumber(BigInteger number);

    /**
     * Удаление платежного поручения по идентификатору
     *
     * @param id
     */
    public void deletePaymentOrderById(Long id);

    /**
     * Редактирование платежного поручения
     */
    public void updatePaymentOrder(PaymentOrder paymentOrder);

    /**
     * Получение всех платежных поручений
     */

    public List<PaymentOrder> getAllPaymentOrder();
}

