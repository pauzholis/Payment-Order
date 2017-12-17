package ru.penza.learnjava.practice.dao;

import ru.penza.learnjava.practice.model.Bank;

import java.util.Collection;

public interface BankDao {

    /**
     * Получение банка по идентификатору
     */
    public Bank getBankById(Long id);

    /**
     * Добавление банка
     */
    public void addBank(Bank bank);

    /**
     * Удаление банка по идентификатору
     */
    public void deleteBankById(Bank bank);

    /**
     * Редактирование банка
     */
    public void updateBank(Bank bank);

    /**
     * Получение списка всех банков
     */
    public Collection<Bank> getAllBanks();
}
