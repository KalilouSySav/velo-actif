package com.example.tpfinsessiongestionvelo.controlleur;

import com.example.tpfinsessiongestionvelo.entities.Client;
import com.example.tpfinsessiongestionvelo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientControlleur {
    private ClientService clientService;
    @Autowired
    public ClientControlleur(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/client/id/leesThen/{id}")
    public List<Client> findClientByIdLessThen(@PathVariable int id) {
        return clientService.findClientByIdLessThen(id);
    }
    @GetMapping("/clients/name")
    public List<Client> findAllByOrderByNameDesc() {
        return clientService.findAllByOrderByNameDesc();
    }
    @GetMapping("/client/name/{name}")
    public List<Client> findClientByFirstNameOrderByLastNameAsc(@PathVariable String name) {
        return clientService.findClientByFirstNameOrderByLastNameAsc(name);
    }
    @PutMapping("/client/{id}")
    public boolean updateClient(@PathVariable int id, @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }
    @DeleteMapping("/client/{id}")
    public boolean deleteClientById(@PathVariable int id) {
        return clientService.deleteClientById(id);
    }
}
