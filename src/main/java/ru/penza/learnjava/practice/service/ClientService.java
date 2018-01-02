package ru.penza.learnjava.practice.service;

import ru.penza.learnjava.practice.view.ClientView;
import ru.penza.learnjava.practice.view.PaymentOrderView;

import java.util.List;

public interface ClientService {
    void getClient(ClientView clientView);
    List<ClientView> getAllClients();
}


