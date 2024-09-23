package com.example.tpfinsessiongestionvelo.service;

import com.example.tpfinsessiongestionvelo.entities.Client;

import java.util.List;

public interface ClientService {


    boolean deleteClientById(int id);

    boolean updateClient(int id, Client client);

    List<Client> findClientByFirstNameOrderByLastNameAsc(String name);

    List<Client> findAllByOrderByNameDesc();

    List<Client> findClientByIdLessThen(int id);
}
