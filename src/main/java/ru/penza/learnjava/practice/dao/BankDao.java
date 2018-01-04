package ru.penza.learnjava.practice.dao;

import ru.penza.learnjava.practice.model.Bank;

import java.util.List;

public interface BankDao {

    /**
     * Получение банка по идентификатору
     */
    public Bank getBankById(Long id);


    /**
     * Удаление банка
     * @param id
     */
    public void deleteBank(Long id);

    /**
     * Редактирование банка
     */
    public void updateBank(Bank bank);

    /**
     * Получение списка всех банков
     */

    public List<Bank> getAllBanks();
}
