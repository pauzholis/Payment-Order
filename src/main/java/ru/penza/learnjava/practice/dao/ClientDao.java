package ru.penza.learnjava.practice.dao;

import ru.penza.learnjava.practice.model.Client;
import java.util.List;


public interface ClientDao {

    /**
     * Получение клиента по идентификатору
     */
    public Client getClientById(Long id);

    /**
     * Удаление клиента
     * @param id
     */
    public void deleteClient (Long id);

    /**
     * Редактирование клиента
     */
    public void updateClient(Client client);

    /**
     * Получение списка всех клиентов
     */
    public List<Client> getAllClient();
}
