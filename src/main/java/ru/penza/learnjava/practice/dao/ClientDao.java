package ru.penza.learnjava.practice.dao;

import ru.penza.learnjava.practice.model.Client;

import java.util.Collection;
import java.util.List;

/**
 * Created by Evgeniy on 17.12.2017.
 */
public interface ClientDao {

    /**
     * Получение клиента по идентификатору
     */
    public Client getClientById(Long id);

    /**
     * Добавление клиента
     */
    public void addClient (Client client);

    /**
     * Удаление клиента
     */
    public void deleteClient (Client client);

    /**
     * Редактирование клиента
     */
    public void updateClient(Client client);

    /**
     * Получение списка всех клиентов
     */
    public List<Client> getAllClient();
}
