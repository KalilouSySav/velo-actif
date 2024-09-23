package com.example.tpfinsessiongestionvelo.utils;

import com.example.tpfinsessiongestionvelo.entities.Client;
import lombok.Data;

import java.util.ArrayList;
@Data
public class CreationClient {
    private ArrayList<Client> clients = new ArrayList<>();
    public CreationClient() {
        ArrayList<Client> clients = new ArrayList<>();
        Client client1 = new Client("John", "Doe", "123456789", "john.doe@example.com") ;
        Client client2 = new Client("Jane", "Doe", "987654321", "janed@outlook.com") ;
        Client client3 = new Client("John", "Smith", "123456789", "smith1234@live.fr") ;
        Client client4 = new Client("Alice", "Smith", "932654321", "alice.smith@example.com");
        Client client5 = new Client("Bob", "Johnson", "555555555", "bob.johnson@example.com");
        Client client6 = new Client("Emily", "Davis", "111111111", "emily.davis@example.com");
        Client client7 = new Client("Michael", "Wilson", "222222222", "michael.wilson@example.com");
        Client client8 = new Client("Sarah", "Thompson", "333333333", "sarah.thompson@example.com");
        Client client9 = new Client("David", "Anderson", "444444444", "david.anderson@example.com");
        Client client10 = new Client("Olivia", "Brown", "666666666", "olivia.brown@example.com");

        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);
        clients.add(client5);
        clients.add(client6);
        clients.add(client7);
        clients.add(client8);
        clients.add(client9);
        clients.add(client10);

        this.clients = clients;
    }
}
