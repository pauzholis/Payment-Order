package ru.penza.learnjava.practice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.penza.learnjava.practice.dao.ClientDao;
import ru.penza.learnjava.practice.model.Client;
import ru.penza.learnjava.practice.service.ClientService;
import ru.penza.learnjava.practice.view.ClientView;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class ClientServiceImpl implements ClientService {
    private final ClientDao dao;

    @Autowired
    public ClientServiceImpl(ClientDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public ClientView getClient(Long id) {
        Client client = dao.getClientById(id);
        return new ClientView(client.getName(), client.getAccount(), client.getInn(), client.getKpp());
    }

    @Override
    @Transactional
    public List<ClientView> getAllClients() {
        List<Client> clients = dao.getAllClient();
        Function<Client, ClientView> mapClient = c -> {
            ClientView clientView = new ClientView();
            clientView.id = c.getId();
            clientView.name = c.getName();
            clientView.account = c.getAccount();
            clientView.inn = c.getInn();
            clientView.kpp = c.getKpp();
            return clientView;
        };
        return clients.stream().map(mapClient).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void update(ClientView view) {
        Client client = new Client(view.name, view.account, view.inn, view.kpp);
        dao.updateClient(client);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.deleteClient(id);
    }
}


