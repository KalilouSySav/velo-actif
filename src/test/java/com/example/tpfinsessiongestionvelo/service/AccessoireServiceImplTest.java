package com.example.tpfinsessiongestionvelo.service;

import com.example.tpfinsessiongestionvelo.entities.Accessoire;
import com.example.tpfinsessiongestionvelo.repository.AccessoireRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class AccessoireServiceImplTest {

    @Mock
    private AccessoireRepository accessoireRepository;

    @InjectMocks
    private AccessoireServiceImpl accessoireService;
    private Accessoire accessoire;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @AfterEach
    void tearDown() {


    }

    @Test
    @DisplayName("Test de la methode saveAccessoireGantSauvegardeGant sauvegarde le gant")
    void saveAccessoireGantSauvegardeGant() {

        //Créer un accessoire: gant
        Accessoire gant = new Accessoire();
        gant.setNom("Gant");
        gant.setDescription("Gant de protection");
        gant.setQuantite(10);
        gant.setSupprimer(false);

        // Définir le comportement du repository mock
        when(accessoireRepository.save(gant)).thenReturn(gant);


        // Appeler la méthode à tester
        boolean resultat = accessoireService.saveAccessoire(gant);

        // Vérifier le résultat
        assertTrue(resultat);

    }

    @Test
    @DisplayName("Test de la methode saveAccessoireNullSauvegardeNull : aucun accessoire n'est sauvegardé")
    void saveAccessoireNullSauvegardeNull() {

        //Créer un accessoire
        Accessoire accessoire = null;

        // Définir le comportement du repository mock
        when(accessoireRepository.save(accessoire)).thenReturn(accessoire);

        // Appeler la méthode à tester
        boolean resultat = accessoireService.saveAccessoire(accessoire);

        // Vérifier le résultat
        assertFalse(resultat);

    }


    @Test
    @DisplayName("Test de la methode updateAccessoireId2ParPompeRetournePompe : la pompe est retournée")
    void updateAccessoireId2ParPompeRetournePompe() {

        //Créer un accessoire: pompe
        Accessoire pompe = new Accessoire();
        pompe.setId(2);
        pompe.setNom("Pompe");
        pompe.setDescription("Pompe à vélo");
        pompe.setQuantite(10);
        pompe.setSupprimer(false);

        // Définir le comportement du repository mock
        when(accessoireRepository.existsById(2)).thenReturn(true);

        // Appeler la méthode à tester
        boolean resultat = accessoireService.updateAccessoire(2, pompe);

        // Vérifier le résultat
        assertTrue(resultat);

    }

    @Test
    @DisplayName("Test de la methode updateAccessoireIdInexistantParPompeRetourneFalse : rien est retournée")
    void updateAccessoireIdInexistantParPompeRetourneFalse() {

        //Créer un accessoire: pompe
        Accessoire pompe = new Accessoire();
        pompe.setId(2);
        pompe.setNom("Pompe");
        pompe.setDescription("Pompe à vélo");
        pompe.setQuantite(10);
        pompe.setSupprimer(false);

        // Définir le comportement du repository mock
        when(accessoireRepository.existsById(2)).thenReturn(false);
        when(accessoireRepository.save(pompe)).thenReturn(pompe);

        // Définir le comportement du service mock
        when(accessoireService.updateAccessoire(2, pompe)).thenReturn(false);

        // Appeler la méthode à tester
        boolean resultat = accessoireService.updateAccessoire(2, pompe);

        // Vérifier le résultat
        assertFalse(resultat);

    }

    @Test
    @DisplayName("Test de la methode deleteAccessoireById2SupprimeAccessoire2 : l'accessoire 2 est supprimé")
    void deleteAccessoireById2SupprimeAccessoire2() {

        //Créer un accessoire: pompe
        Accessoire pompe = new Accessoire();
        pompe.setId(2);
        pompe.setNom("Pompe");
        pompe.setDescription("Pompe à vélo");
        pompe.setQuantite(10);
        pompe.setSupprimer(false);

        // Définir le comportement du repository mock
        when(accessoireRepository.existsById(2)).thenReturn(true);
        when(accessoireRepository.findById(2)).thenReturn(java.util.Optional.of(pompe));
        when(accessoireRepository.save(pompe)).thenReturn(pompe);

        // Définir le comportement du service mock
        when(accessoireService.deleteAccessoireById(eq(2))).thenReturn(Boolean.TRUE);


        // Appeler la méthode à tester
        boolean resultat = accessoireService.deleteAccessoireById(2);

        // Vérifier le résultat
        assertTrue(resultat);

    }

    @Test
    @DisplayName("Test de la methode deleteAccessoireByIdInexistantRetourneFalse : rien est supprimé")
    void deleteAccessoireByIdInexistantRetourneFalse() {

        //Créer un accessoire: pompe
        Accessoire pompe = new Accessoire();
        pompe.setId(2);
        pompe.setNom("Pompe");
        pompe.setDescription("Pompe à vélo");
        pompe.setQuantite(10);
        pompe.setSupprimer(false);

        // Définir le comportement du repository mock
        when(accessoireRepository.existsById(2)).thenReturn(false);
        when(accessoireRepository.findById(2)).thenReturn(java.util.Optional.of(pompe));
        when(accessoireRepository.save(pompe)).thenReturn(pompe);

        // Définir le comportement du service mock
        when(accessoireService.deleteAccessoireById(eq(2))).thenReturn(Boolean.FALSE);

        // Appeler la méthode à tester
        boolean resultat = accessoireService.deleteAccessoireById(2);

        // Vérifier le résultat
        assertFalse(resultat);

    }

    @Test
    @DisplayName("Test de la methode findAccessoireById2RetournePompe : la pompe est retournée")
    void findAccessoireById2RetournePompe() {

        //Créer un accessoire: pompe
        Accessoire pompe = new Accessoire();
        pompe.setId(2);
        pompe.setNom("Pompe");
        pompe.setDescription("Pompe à vélo");
        pompe.setQuantite(10);
        pompe.setSupprimer(false);

//        // Définir le comportement du repository mock
        when(accessoireRepository.findById(2)).thenReturn(java.util.Optional.of(pompe));
        when(accessoireRepository.existsById(2)).thenReturn(true);



        // Appeler la méthode à tester
        Accessoire resultat = accessoireService.findAccessoireById(2);

        // Vérifier le résultat
        assertEquals(pompe, resultat);
    }
    @Test
    @DisplayName("Test de la methode findAccessoireByIdInexistantRetourneNull : rien est retournée")
    void findAccessoireByIdInexistantRetourneNull() {

        //Créer un accessoire: pompe
        Accessoire nulle = null;

        // Définir le comportement du repository mock
        when(accessoireRepository.existsById(2)).thenReturn(false);

        // Appeler la méthode à tester
        Accessoire resultat = accessoireService.findAccessoireById(2);

        // Vérifier le résultat
        assertNull(resultat);
    }

    @Test
    @DisplayName("Test de la methode findAccessoireByNamePompeRetournePompe : la pompe est retournée")
    void findAccessoireByNamePompeRetournePompe() {

            //Créer un accessoire: pompe
            Accessoire pompe = new Accessoire();
            pompe.setId(2);
            pompe.setNom("Pompe");
            pompe.setDescription("Pompe à vélo");
            pompe.setQuantite(10);
            pompe.setSupprimer(false);

            List<Accessoire> accessoires = new ArrayList<>();
            accessoires.add(pompe);

            // Définir le comportement du repository mock
            when(accessoireRepository.findByNomContaining("Pompe")).thenReturn(accessoires);

            // Définir le comportement du service mock
            when(accessoireService.findAccessoireByName("Pompe")).thenReturn(accessoires);

            // Appeler la méthode à tester
            List<Accessoire> resultat = accessoireService.findAccessoireByName("Pompe");

            // Vérifier le résultat
            assertEquals(accessoires, resultat);
    }
    @Test
    @DisplayName("Test de la methode findAccessoireByNameInexistantRetourneNull : rien est retournée")
    void findAccessoireByNameInexistantRetourneNull() {

        //Créer un accessoire: pompe
        Accessoire nulle = null;

        // Définir le comportement du repository mock
        when(accessoireRepository.findByNomContaining("Pompe")).thenReturn(null);

        // Appeler la méthode à tester
        List<Accessoire> resultat = accessoireService.findAccessoireByName("Pompe");

        // Vérifier le résultat
        assertNull(resultat);
    }

    @Test
    @DisplayName("Test de la methode findAllListeAccessoireRetourneListeAccessoire :" +
            " la liste des accessoires est retournée")
    void findAllListeAccessoireRetourneListeAccessoire() {

            //Créer un accessoire: pompe
            Accessoire pompe = new Accessoire();
            pompe.setId(2);
            pompe.setNom("Pompe");
            pompe.setDescription("Pompe à vélo");
            pompe.setQuantite(10);
            pompe.setSupprimer(false);

            Accessoire casque = new Accessoire();
            casque.setId(3);
            casque.setNom("Casque");
            casque.setDescription("Casque de vélo");
            casque.setQuantite(10);
            casque.setSupprimer(false);

            List<Accessoire> accessoires = new ArrayList<>();
            accessoires.add(pompe);
            accessoires.add(casque);

            // Définir le comportement du repository mock
            when(accessoireRepository.findAll()).thenReturn(accessoires);

            // Définir le comportement du service mock
            when(accessoireService.findAll()).thenReturn(accessoires);

            // Appeler la méthode à tester
            List<Accessoire> resultat = accessoireService.findAll();

            // Vérifier le résultat
            assertEquals(accessoires, resultat);
            assert(resultat.size() == 2);

    }
    @Test
    @DisplayName("Test de la methode findAllListeAccessoireRetourneListeAccessoireVide :" +
            " une liste vide est retournée")
    void findAllListeAccessoireRetourneListeAccessoireVide() {

            List<Accessoire> accessoires = new ArrayList<>();

            // Définir le comportement du repository mock
            when(accessoireRepository.findAll()).thenReturn(accessoires);

            // Définir le comportement du service mock
            when(accessoireService.findAll()).thenReturn(accessoires);

            // Appeler la méthode à tester
            List<Accessoire> resultat = accessoireService.findAll();

            // Vérifier le résultat
            assertEquals(accessoires, resultat);
            assert(resultat.size() == 0);

    }
}