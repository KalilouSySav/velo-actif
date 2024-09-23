package com.example.tpfinsessiongestionvelo.service;

import com.example.tpfinsessiongestionvelo.entities.VeloDetail;
import com.example.tpfinsessiongestionvelo.repository.VeloDetailRepository;
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

class VeloDetailServiceImplTest {

    @Mock
    private VeloDetailRepository veloDetailRepository;
    @InjectMocks
    private VeloDetailServiceImpl veloDetailServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("updateVeloDetailId1ParVelo1() retourne un nouveau VeloDetail modifié")
    void updateVeloDetailId1ParVelo1() {
        //Création d'un VeloDetail
        VeloDetail veloDetail = new VeloDetail();
        veloDetail.setId(1);
        veloDetail.setPrixLocation(10.0);

        //Définition du comportement du mock
        when(veloDetailRepository.existsById(1)).thenReturn(true);
        when(veloDetailRepository.findById(1)).thenReturn(java.util.Optional.of(veloDetail));
        when(veloDetailRepository.save(veloDetail)).thenReturn(veloDetail);

        //Appel de la méthode à tester
        boolean resultat = veloDetailServiceImplUnderTest.updateVeloDetail(1, veloDetail);

        //Vérification du résultat
        assertTrue(resultat);

    }
    @Test
    @DisplayName("updateVeloDetailId10Inexistant() retourne false")
    void updateVeloDetailId10Inexistant() {
        //Création d'un VeloDetail
        VeloDetail veloDetail = new VeloDetail();
        veloDetail.setId(10);
        veloDetail.setPrixLocation(10.0);

        //Définition du comportement du mock
        when(veloDetailRepository.existsById(10)).thenReturn(false);

        //Appel de la méthode à tester
        boolean resultat = veloDetailServiceImplUnderTest.updateVeloDetail(10, veloDetail);

        //Vérification du résultat
        assertFalse(resultat);

    }

    @Test
    @DisplayName("findVeloDetailByPrixLocationBetween1Et30() " +
            "retourne une liste de VeloDetail avec un prix de location entre 1 et 30")
    void findVeloDetailByPrixLocationBetween1Et30() {
        //Création d'une liste de VeloDetail
        VeloDetail veloDetail1 = new VeloDetail();
        veloDetail1.setId(1);
        veloDetail1.setPrixLocation(10.0);

        VeloDetail veloDetail2 = new VeloDetail();
        veloDetail2.setId(2);
        veloDetail2.setPrixLocation(20.0);

        List<VeloDetail> listeVeloDetail = List.of(veloDetail1, veloDetail2);

        //Définition du comportement du mock
        when(veloDetailRepository.findVeloDetailByPrixLocationBetween(1.0, 30.0)).thenReturn(listeVeloDetail);
    }
    @Test
    @DisplayName("findVeloDetailByPrixLocationInexistantBetween100Et200() " +
            "retourne une liste de VeloDetail vide")
    void findVeloDetailByPrixLocationInexistantBetween100Et200() {
        //Définition du comportement du mock
        when(veloDetailRepository.findVeloDetailByPrixLocationBetween(100.0, 200.0)).thenReturn(List.of());

        //Appel de la méthode à tester
        List<VeloDetail> resultat = veloDetailServiceImplUnderTest.findVeloDetailByPrixLocationBetween(100.0, 200.0);

        //Vérification du résultat
        assertEquals(0, resultat.size());
    }
}