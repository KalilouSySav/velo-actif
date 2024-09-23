package com.example.tpfinsessiongestionvelo.service;

import com.example.tpfinsessiongestionvelo.entities.Client;
import com.example.tpfinsessiongestionvelo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{
    private ClientRepository clientRepository;
    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public boolean deleteClientById(int id) {
        if (!clientRepository.existsById(id)) {
            return false;
        }
        Client client = clientRepository.findById(id).get();
        client.setSupprimer(true);
        clientRepository.save(client);
        return true;
    }

    @Override
    public boolean updateClient(int id, Client client) {
        if (client == null || !clientRepository.existsById(id)) {
            return false;
        }
        client.setId(id);
        clientRepository.save(client);
        return true;
    }

    @Override
    public List<Client> findClientByFirstNameOrderByLastNameAsc(String name) {
        if (name == null) {
            return null;
        }
        return clientRepository.findClientByPrenomOrderByNomAsc(name);
    }

    @Override
    public List<Client> findAllByOrderByNameDesc() {
        return clientRepository.findAllByOrderByNomDesc();
    }

    @Override
    public List<Client> findClientByIdLessThen(int id) {
    List<Client> clients = null;
    if (id <= 0) {
            return clients;
        }
        return clientRepository.findClientByIdLessThan(id);
    }
}
