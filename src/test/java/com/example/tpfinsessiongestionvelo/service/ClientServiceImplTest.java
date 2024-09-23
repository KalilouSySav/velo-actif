package com.example.tpfinsessiongestionvelo.service;

import com.example.tpfinsessiongestionvelo.entities.Client;
import com.example.tpfinsessiongestionvelo.repository.ClientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepository;
    @InjectMocks
    private ClientServiceImpl clientServiceImplUnderTest;
    private Client client;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("deleteClientById2SupprimeClientId2: le client avec l'id 2 est supprimé")
    void deleteClientById2SupprimeClientId2() {
        //Création du client
        client = new Client();
        client.setId(2);
        client.setPrenom("Jean");
        client.setNom("Dupont");
        client.setCourriel("dupontco@gmail.com");
        client.setTelephone("514-555-5555");
        client.setSupprimer(false);

        //Définition du comportement du mock
        when(clientRepository.existsById(2)).thenReturn(true);
        when(clientRepository.findById(2)).thenReturn(Optional.of(client));
        when(clientRepository.save(client)).thenReturn(client);

        //Appel de la méthode à tester
        boolean resultat = clientServiceImplUnderTest.deleteClientById(2);

        //Vérification du résultat
        assertTrue(resultat);

    }
    @Test
    @DisplayName("deleteClientById2InexistantSupprimeAucun: aucun client n'est supprimé")
    void deleteClientById2InexistantSupprimeAucun() {
        // définition du comportement du mock
        when(clientRepository.existsById(2)).thenReturn(false);

        // appel de la méthode à tester
        boolean resultat = clientServiceImplUnderTest.deleteClientById(2);

        // vérification du résultat
        assertFalse(resultat);
    }

    @Test
    @DisplayName("updateClientId2parJackRetourneNouveauClientJack: le client avec l'id 2 est modifié")
    void updateClientId2parJackRetourneNouveauClientJack() {
        //Création du client
        client = new Client();
        client.setId(2);
        client.setPrenom("Jack");
        client.setNom("Dupont");
        client.setCourriel("dupontco@gmail.com");
        client.setTelephone("514-555-5555");
        client.setSupprimer(false);

        // Définir le comportement du repository mock
        when(clientRepository.existsById(2)).thenReturn(true);

        //Appel de la méthode à tester
        boolean resultat = clientServiceImplUnderTest.updateClient(2, client);

        //Vérification du résultat
        assertTrue(resultat);

    }
    @Test
    @DisplayName("updateClientId2InexistantparJackRetourneFaux: rien n'est pas modifié")
    void updateClientId2InexistantparJackRetourneFaux() {
        //Création du client
        client = new Client();
        client.setId(2);
        client.setPrenom("Jack");
        client.setNom("Dupont");
        client.setCourriel("dupontco@gmail.com");
        client.setTelephone("514-555-5555");
        client.setSupprimer(false);

        // Définir le comportement du repository mock
        when(clientRepository.existsById(2)).thenReturn(false);

        //Appel de la méthode à tester
        boolean resultat = clientServiceImplUnderTest.updateClient(2, client);

        //Vérification du résultat
        assertFalse(resultat);

    }

    @Test
    @DisplayName("findClientByFirstNameJasmineOrderByLastNameMainAsuraAscRetournelisteClientJasmineEnOrdre:" +
            " la liste des clients avec le prénom Jasmine est retournée en ordre ascendant par nom")
    void findClientByFirstNameJasmineOrderByLastNameMainAsuraAscRetournelisteClientJasmineEnOrdre() {

        //Création des clients
        Client client1 = new Client();
        client1.setId(1);
        client1.setPrenom("Jasmine");
        client1.setNom("Main");
        client1.setCourriel("jsmine@live.com");
        client1.setTelephone("514-555-5555");
        client1.setSupprimer(false);

        Client client2 = new Client();
        client2.setId(2);
        client2.setPrenom("Jasmine");
        client2.setNom("Asura");
        client2.setCourriel("asuradaimon@yahoo.fr");
        client2.setTelephone("514-555-5555");
        client2.setSupprimer(false);

        List<Client> listeClients = List.of(client1, client2);

        //Définition du comportement du mock
        when(clientRepository.findClientByPrenomOrderByNomAsc("Jasmine"))
                .thenReturn(listeClients);

        //Appel de la méthode à tester
        List<Client> resultat = clientServiceImplUnderTest
                .findClientByFirstNameOrderByLastNameAsc("Jasmine");

        //Vérification du résultat
        assertEquals(listeClients, resultat);

    }
    @Test
    @DisplayName("findClientByFirstNameNullOrderByLastNameMainAsuraDescRetourneListeVide: " +
            "Une liste vide est retournée")
    void findClientByFirstNameNullOrderByLastNameMainAsuraDescRetourneListeVide() {

            //Définition du comportement du mock
            when(clientRepository.findClientByPrenomOrderByNomAsc(""))
                    .thenReturn(List.of());

            //Appel de la méthode à tester
            List<Client> resultat = clientServiceImplUnderTest
                    .findClientByFirstNameOrderByLastNameAsc("");

            //Vérification du résultat
            assertEquals(List.of(), resultat);

    }

    @Test
    @DisplayName("findALLByOrderByNameDescRetourneListeClientOrdoneeParNom: " +
            "Une liste de clients ordonnée par nom est retournée")
    void findAllByOrderByNameDescRetourneListeClientOrdoneeParNom() {

            //Création des clients
            Client client1 = new Client();
            client1.setId(1);
            client1.setPrenom("Jasmine");
            client1.setNom("Main");
            client1.setCourriel("jasmain@outlook.com");
            client1.setTelephone("514-555-5555");
            client1.setSupprimer(false);

            Client client2 = new Client();
            client2.setId(2);
            client2.setPrenom("Samuel");
            client2.setNom("Roy");
            client2.setCourriel("roy09@hotmail.com");
            client2.setTelephone("514-555-5555");
            client2.setSupprimer(false);

            List<Client> listeClients = List.of(client1, client2);

            //Définition du comportement du mock
            when(clientRepository.findAllByOrderByNomDesc())
                    .thenReturn(listeClients);

            //Appel de la méthode à tester
            List<Client> resultat = clientServiceImplUnderTest
                    .findAllByOrderByNameDesc();

            //Vérification du résultat
            assertEquals(listeClients, resultat);
    }
    @Test
    @DisplayName("findALLByOrderByNameDescRetourneListeVide: " +
            "Une liste vide est retournée")
    void findAllByOrderByNameDescRetourneListeVide() {

                //Définition du comportement du mock
                when(clientRepository.findAllByOrderByNomDesc())
                        .thenReturn(List.of());

                //Appel de la méthode à tester
                List<Client> resultat = clientServiceImplUnderTest
                        .findAllByOrderByNameDesc();

                //Vérification du résultat
                assertEquals(List.of(), resultat);

    }

    @Test
    @DisplayName("findClientByIdLessThen3RetourneListeClientIdInferieur3: " +
            "Une liste de clients avec un id inférieur à 3 est retournée")
    void findClientByIdLessThen3RetourneListeClientIdInferieur3() {

            //Création des clients
            Client client1 = new Client();
            client1.setId(1);
            client1.setPrenom("Jasmine");
            client1.setNom("Main");
            client1.setCourriel("mainmine@live.ca");
            client1.setTelephone("514-555-5555");
            client1.setSupprimer(false);

            Client client2 = new Client();
            client2.setId(2);
            client2.setPrenom("Samuel");
            client2.setNom("Roy");
            client2.setCourriel("samroy@mail.com");
            client2.setTelephone("514-555-5555");
            client2.setSupprimer(false);

            List<Client> listeClients = List.of(client1, client2);

            //Définition du comportement du mock
            when(clientRepository.findClientByIdLessThan(3))
                    .thenReturn(listeClients);

            //Appel de la méthode à tester
            List<Client> resultat = clientServiceImplUnderTest
                    .findClientByIdLessThen(3);

            //Vérification du résultat
            assertEquals(listeClients, resultat);
    }
    @Test
    @DisplayName("findClientByIdInexistantRetourneListeVide: " +
            "Une liste vide est retournée")
    void findClientByIdInexistantRetourneListeVide() {

        //Définition du comportement du mock
        when(clientRepository.findClientByIdLessThan(3))
                .thenReturn(List.of());

        //Appel de la méthode à tester
        List<Client> resultat = clientServiceImplUnderTest
                .findClientByIdLessThen(3);

        //Vérification du résultat
        assertEquals(List.of(), resultat);

    }
}