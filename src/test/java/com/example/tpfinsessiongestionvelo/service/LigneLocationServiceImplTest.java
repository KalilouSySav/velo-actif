package com.example.tpfinsessiongestionvelo.service;

import com.example.tpfinsessiongestionvelo.entities.LigneLocation;
import com.example.tpfinsessiongestionvelo.repository.LigneLocationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class LigneLocationServiceImplTest {
    @Mock
    private LigneLocationRepository ligneLocationRepository;
    @InjectMocks
    private LigneLocationServiceImpl ligneLocationServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("findLigneLocationByIdGreaterThan(2)" +
            " retourne une liste de LigneLocation dont l'id est supérieur à 2")
    void findLigneLocationByIdGreaterThen2RetourneListeLigneLocationIdSuperieur2() {
        //Création d'une liste de LigneLocation
        LigneLocation ligneLocation1 = new LigneLocation();
        ligneLocation1.setId(5);
        ligneLocation1.setQuanitite(1);
        ligneLocation1.setTarif(10.0);

        LigneLocation ligneLocation2 = new LigneLocation();
        ligneLocation2.setId(6);
        ligneLocation2.setQuanitite(3);
        ligneLocation2.setTarif(30.0);

        List<LigneLocation> listeLigneLocation = List.of(ligneLocation1, ligneLocation2);

        //Définition du comportement du mock
        when(ligneLocationRepository.existsById(2)).thenReturn(true);
        when(ligneLocationRepository.findLigneLocationByIdGreaterThan(2)).thenReturn(listeLigneLocation);


        //Appel de la méthode à tester
        List<LigneLocation> resultat = ligneLocationServiceImplUnderTest
                .findLigneLocationByIdGreaterThen(2);

        //Vérification du résultat
        assertEquals(listeLigneLocation, resultat);
    }
    @Test
    @DisplayName("findLigneLocationByIdGreaterThanInexistant(2)" +
            " retourne une liste vide")
    void findLigneLocationByIdGreaterThenInexistantRetourneListeVide() {
        //Création d'une liste de LigneLocation
        List<LigneLocation> listeLigneLocation = List.of();

        //Définition du comportement du mock
        when(ligneLocationRepository.existsById(2)).thenReturn(false);
        when(ligneLocationRepository.findLigneLocationByIdGreaterThan(2)).thenReturn(listeLigneLocation);
    }

    @Test
    @DisplayName("findALlOrderByTarifAsc() retourne une liste de LigneLocation ordonnée par tarif ascendant")
    void findAllOrderByTarifAscListeLocationsRetourneListeLocationOrdonnee() {
        //Création d'une liste de LigneLocation
        LigneLocation ligneLocation1 = new LigneLocation();
        ligneLocation1.setId(5);
        ligneLocation1.setQuanitite(1);
        ligneLocation1.setTarif(10.0);

        LigneLocation ligneLocation2 = new LigneLocation();
        ligneLocation2.setId(6);
        ligneLocation2.setQuanitite(3);
        ligneLocation2.setTarif(30.0);

        List<LigneLocation> listeLigneLocation = List.of(ligneLocation1, ligneLocation2);

        //Définition du comportement du mock
        when(ligneLocationRepository.findAllByOrderByTarifAsc()).thenReturn(listeLigneLocation);

        //Appel de la méthode à tester
        List<LigneLocation> resultat = ligneLocationServiceImplUnderTest.findAllOrderByTarifAsc();

        //Vérification du résultat
        assertEquals(listeLigneLocation, resultat);
    }
    @Test
    @DisplayName("findALlOrderByTarifAsc() retourne une liste vide")
    void findAllOrderByTarifAscListeLocationsRetourneListeVide() {
        //Création d'une liste de LigneLocation
        List<LigneLocation> listeLigneLocation = List.of();

        //Définition du comportement du mock
        when(ligneLocationRepository.findAllByOrderByTarifAsc()).thenReturn(listeLigneLocation);

        //Appel de la méthode à tester
        List<LigneLocation> resultat = ligneLocationServiceImplUnderTest.findAllOrderByTarifAsc();

        //Vérification du résultat
        assertEquals(listeLigneLocation, resultat);
    }

    @Test
    @DisplayName("deleteLigneLocationById2() supprime la ligneLocation dont l'id est 2")
    void deleteLigneLocationById2SupprimeLigneLocationId2() {
        //Définition du comportement du mock
        when(ligneLocationRepository.existsById(2)).thenReturn(true);

        //Appel de la méthode à tester
        boolean resultat = ligneLocationServiceImplUnderTest.deleteLigneLocationById(2);

        //Vérification du résultat
        assertTrue(resultat);
    }
    @Test
    @DisplayName("deleteLigneLocationByIdInexistant2() ne supprime aucune ligne de Location")
    void deleteLigneLocationByIdInexistant2NeSupprimeAucuneLigneLocation() {
        //Définition du comportement du mock
        when(ligneLocationRepository.existsById(2)).thenReturn(false);

        //Appel de la méthode à tester
        boolean resultat = ligneLocationServiceImplUnderTest.deleteLigneLocationById(2);

        //Vérification du résultat
        assertFalse(resultat);
    }
}