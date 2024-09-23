package com.example.tpfinsessiongestionvelo.service;

import com.example.tpfinsessiongestionvelo.entities.Client;
import com.example.tpfinsessiongestionvelo.entities.Location;
import com.example.tpfinsessiongestionvelo.repository.LocationRepository;
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

class LocationServiceImplTest {
    @Mock
    private LocationRepository locationRepository;
    @InjectMocks
    private LocationServiceImpl locationServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("findAllByClientId(1) retourne location avec clientId = 1")
    void findAllByClientId1RetourneLocationAvecClientId1() {

        // Créer un objet Location
        Location location = new Location();
        location.setId(1);
        location.setDateDebut("12:00");
        location.setDateFin("14:00");
        location.setClient(new Client());
        location.getClient().setId(1);

        Location location2 = new Location();
        location2.setId(2);
        location2.setDateDebut("12:00");
        location2.setDateFin("17:00");
        location2.setClient(new Client());
        location2.getClient().setId(1);

        List<Location> locations = List.of(location, location2);

        // Définir le comportement du mock
        when(locationRepository.existsByClientId(1)).thenReturn(true);
        when(locationRepository.findAllByClientId(1)).thenReturn(locations);

        // Appel de la méthode à tester
        List<Location> resultat = locationServiceImplUnderTest.findAllByClientId(1);

        // Vérification du résultat
        assertEquals(locations, resultat);
    }
    @Test
    @DisplayName("findAllByClientIdInexistant(1) retourne liste vide de location")
    void findAllByClientIdInexistant1RetourneListeVideLocation() {

        List<Location> locations = null;

        // Définir le comportement du mock
        when(locationRepository.existsByClientId(1)).thenReturn(false);
        when(locationRepository.findAllByClientId(1)).thenReturn(locations);

        // Appel de la méthode à tester
        List<Location> resultat = locationServiceImplUnderTest.findAllByClientId(1);

        // Vérification du résultat
        assertEquals(locations, resultat);
    }

    @Test
    @DisplayName("deleteLocationById2 supprime ligne location id 2")
    void deleteLocationById2SupprimeLigneLocationId2() {
        // définir le comportement du mock
        when(locationRepository.existsById(2)).thenReturn(true);
        when(locationRepository.findById(2)).thenReturn(java.util.Optional.of(new Location()));
        when(locationRepository.save(new Location())).thenReturn(new Location());

        // appel de la méthode à tester
        boolean resultat = locationServiceImplUnderTest.deleteLocationById(2);

        // vérification du résultat
        assertTrue(resultat);
    }
    @Test
    @DisplayName("deleteLocationByIdInexistant2 retourne false")
    void deleteLocationByIdInexistant2RetourneFalse() {
        // définir le comportement du mock
        when(locationRepository.existsById(2)).thenReturn(false);

        // appel de la méthode à tester
        boolean resultat = locationServiceImplUnderTest.deleteLocationById(2);

        // vérification du résultat
        assertFalse(resultat);
    }

    @Test
    @DisplayName("findLocationByIdGreaterThan2OrderByIdDesc " +
            "retourne liste de location supérieur à 2 et ordonnée par id décroissant")
    void findLocationByIdGreaterThan2OrderByIdDesc() {
        // Créer un objet Location
        Location location = new Location();
        location.setId(3);
        location.setDateDebut("12:00");
        location.setDateFin("14:00");
        location.setClient(new Client());
        location.getClient().setId(1);

        Location location2 = new Location();
        location2.setId(4);
        location2.setDateDebut("12:00");
        location2.setDateFin("17:00");
        location2.setClient(new Client());
        location2.getClient().setId(1);

        List<Location> locations = List.of(location, location2);

        // Définir le comportement du mock
        when(locationRepository.findLocationByIdGreaterThanOrderByIdDesc(2)).thenReturn(locations);

        // Appel de la méthode à tester
        List<Location> resultat = locationServiceImplUnderTest.findLocationByIdGreaterThanOrderByIdDesc(2);

        // Vérification du résultat
        assertEquals(locations, resultat);
    }
    @Test
    @DisplayName("findLocationByIdGreaterThan2OrderByIdDescInexistant " +
            "retourne liste vide")
    void findLocationByIdGreaterThan2OrderByIdDescInexistant() {
        // Définir le comportement du mock
        when(locationRepository.findLocationByIdGreaterThanOrderByIdDesc(2)).thenReturn(null);

        // Appel de la méthode à tester
        List<Location> resultat = locationServiceImplUnderTest.findLocationByIdGreaterThanOrderByIdDesc(2);

        // Vérification du résultat
        assertNull(resultat);
    }
}