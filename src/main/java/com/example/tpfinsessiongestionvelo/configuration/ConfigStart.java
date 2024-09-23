package com.example.tpfinsessiongestionvelo.configuration;

import com.example.tpfinsessiongestionvelo.entities.*;
import com.example.tpfinsessiongestionvelo.repository.ClientRepository;

import com.example.tpfinsessiongestionvelo.utils.*;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ConfigStart implements CommandLineRunner {
   private ClientRepository clientRepository;

    public ConfigStart(ClientRepository clientRepository) {this.clientRepository = clientRepository;}

    @Transactional //on utilise le transactionnel pour updater ce qui a été sauvegarder
    @Override
    public void run(String... args) throws Exception {
        // initialise les données

        // Execute le script seulement si la base de données est
        if (clientRepository.findAll().isEmpty()) {
        //on crée les clients avec les locations
        createClientWithLocation(clientRepository);
        }
    }

    private void createClientWithLocation(ClientRepository clientRepository) {

        //on crée les listes d'objets clients, locations, ligneLocations, accessoires, velos, veloDetails
        ArrayList<Client> clients = new CreationClient().getClients();
        ArrayList<Location> locations = new CreationLocation().getLocationList();
        ArrayList<LigneLocation> ligneLocations = new CreationLigneLocation().getLigneLocationList();
        ArrayList<Accessoire> accessoires = new CreationAccessoire().getAccessoires();
        ArrayList<Velo> velos = new CreationVelo().getVeloList();
        ArrayList<VeloDetail> veloDetails = new CreationVeloDetail().getVeloDetails();


        // On crée les relations entre les objets
        int size = 10; //on prend 10 objets de chaque liste
        for (int i = 0; i < size; i++) {
            Client client = clients.get(i);
            Location location = locations.get(i);
            LigneLocation ligneLocation = ligneLocations.get(i);
            Velo velo = velos.get(i);
            VeloDetail veloDetail = veloDetails.get(i);
            Accessoire accessoire = accessoires.get(i);

            velo.setVeloDetail(veloDetail);
            veloDetail.setVelo(velo);

            velo.addAccessoire(accessoire);
            accessoire.addVelo(velo);

            ligneLocation.setVelo(velo);

            location.addLigneLocation(ligneLocation);
            ligneLocation.setLocation(location);

            client.addLocation(location);
            location.setClient(client);
        }
        //on affiche dans la console avant de sauvegarder
        System.out.println("Clients : " + clients);
        System.out.println("Locations : " + locations);

        // Sauvegarde des objets
        clientRepository.saveAll(clients);

    }

}
