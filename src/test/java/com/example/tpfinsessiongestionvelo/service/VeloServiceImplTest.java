package com.example.tpfinsessiongestionvelo.service;

import com.example.tpfinsessiongestionvelo.entities.Velo;
import com.example.tpfinsessiongestionvelo.entities.VeloDetail;
import com.example.tpfinsessiongestionvelo.repository.VeloRepository;
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

class VeloServiceImplTest {

    @Mock
    private VeloRepository veloRepository;
    @InjectMocks
    private VeloServiceImpl veloServiceImplUnderTest;
    private Velo velo;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void updateVeloId1ParVelo1() {
        //Création d'un Velo
        Velo velo1 = new Velo();
        velo1.setId(1);
        velo1.setNom("Velo1");
        velo1.setVeloDetail(new VeloDetail());
        velo1.getVeloDetail().setId(1);

        //Définition du comportement du mock
        when(veloRepository.existsById(1)).thenReturn(true);
        when(veloRepository.findById(1)).thenReturn(java.util.Optional.of(velo1));
        when(veloRepository.save(velo1)).thenReturn(velo1);

        //Appel de la méthode à tester
        boolean resultat = veloServiceImplUnderTest.updateVelo(1, velo1);

        //Vérification du résultat
        assertTrue(resultat);

    }
    @Test
    @DisplayName("updateVeloId10Inexistant() retourne false")
    void updateVeloId10Inexistant() {
        //Création d'un Velo
        Velo velo1 = new Velo();
        velo1.setId(10);
        velo1.setNom("Velo1");
        velo1.setVeloDetail(new VeloDetail());
        velo1.getVeloDetail().setId(1);

        //Définition du comportement du mock
        when(veloRepository.existsById(10)).thenReturn(false);

        //Appel de la méthode à tester
        boolean resultat = veloServiceImplUnderTest.updateVelo(10, velo1);

        //Vérification du résultat
        assertFalse(resultat);

    }

    @Test
    @DisplayName("deleteVeloVelo1SupprimeVelo1() retourne true")
    void deleteVeloVelo1SupprimeVelo1() {
        //Création d'un Velo
        Velo velo1 = new Velo();
        velo1.setId(1);
        velo1.setNom("Velo1");
        velo1.setVeloDetail(new VeloDetail());
        velo1.getVeloDetail().setId(1);

        //Définition du comportement du mock
        when(veloRepository.existsById(1)).thenReturn(true);
        when(veloRepository.findById(1)).thenReturn(java.util.Optional.of(velo1));
        when(veloRepository.save(velo1)).thenReturn(velo1);

        //Appel de la méthode à tester
        boolean resultat = veloServiceImplUnderTest.deleteVelo(1);

        //Vérification du résultat
        assertTrue(resultat);

    }
    @Test
    @DisplayName("deleteVeloVelo10Inexistant() retourne false")
    void deleteVeloVelo10Inexistant() {
        //Création d'un Velo
        Velo velo1 = new Velo();
        velo1.setId(10);
        velo1.setNom("Velo1");
        velo1.setVeloDetail(new VeloDetail());
        velo1.getVeloDetail().setId(1);

        //Définition du comportement du mock
        when(veloRepository.existsById(10)).thenReturn(false);

        //Appel de la méthode à tester
        boolean resultat = veloServiceImplUnderTest.deleteVelo(10);

        //Vérification du résultat
        assertFalse(resultat);

    }

    @Test
    @DisplayName("saveVeloVelo1SauvegardeVelo1() retourne true")
    void saveVeloVelo1SauvegardeVelo1() {
        //Création d'un Velo
        Velo velo1 = new Velo();
        velo1.setId(1);
        velo1.setNom("Velo1");
        velo1.setVeloDetail(new VeloDetail());
        velo1.getVeloDetail().setId(1);

        //Définition du comportement du mock
        when(veloRepository.save(velo1)).thenReturn(velo1);

        //Appel de la méthode à tester
        boolean resultat = veloServiceImplUnderTest.saveVelo(velo1);

        //Vérification du résultat
        assertTrue(resultat);

    }
    @Test
    @DisplayName("saveVeloVeloNull() retourne false")
    void saveVeloVeloNull() {
        //Création d'un Velo
        Velo velo1 = null;

        //Définition du comportement du mock
        when(veloRepository.save(velo1)).thenReturn(velo1);

        //Appel de la méthode à tester
        boolean resultat = veloServiceImplUnderTest.saveVelo(velo1);

        //Vérification du résultat
        assertFalse(resultat);

    }

    @Test
    @DisplayName("findAllOrderByNameAscRetourneListeOrdonne()" +
            "retourne une liste ordonnée par nom croissant")
    void findAllOrderByNameAscRetourneListeOrdonne() {
        //Création d'un Velo
        Velo Flash = new Velo();
        Flash.setId(1);
        Flash.setNom("Velo1");
        Flash.setVeloDetail(new VeloDetail());
        Flash.getVeloDetail().setId(1);

        Velo Sonic = new Velo();
        Sonic.setId(2);
        Sonic.setNom("Velo2");
        Sonic.setVeloDetail(new VeloDetail());
        Sonic.getVeloDetail().setId(2);

        List<Velo> velos = List.of(Flash, Sonic);

        //Définition du comportement du mock
        when(veloRepository.findAllByOrderByNomAsc()).thenReturn(velos);

        //Appel de la méthode à tester
        List<Velo> resultat = veloServiceImplUnderTest.findAllOrderByNameAsc();

        //Vérification du résultat
        assertEquals(velos, resultat);

    }
    @Test
    @DisplayName("findAllOrderByNameAscListeVide()" +
            "retourne une liste vide")
    void findAllOrderByNameAscListeVide() {
        //Création d'un Velo
        List<Velo> velos = List.of();

        //Définition du comportement du mock
        when(veloRepository.findAllByOrderByNomAsc()).thenReturn(velos);

        //Appel de la méthode à tester
        List<Velo> resultat = veloServiceImplUnderTest.findAllOrderByNameAsc();

        //Vérification du résultat
        assertEquals(velos, resultat);

    }

    @Test
    @DisplayName("findByIdGreaterThan1OrderByTailleAsc() retourne une liste ordonnée par taille croissante")
    void findByIdGreaterThan1OrderByTailleAsc() {
        //Création d'un Velo
        Velo Flash = new Velo();
        Flash.setId(6);
        Flash.setNom("Velo1");
        Flash.setTaille("M");
        Flash.setVeloDetail(new VeloDetail());
        Flash.getVeloDetail().setId(6);

        Velo Sonic = new Velo();
        Sonic.setId(7);
        Sonic.setNom("Velo2");
        Sonic.setTaille("S");
        Sonic.setVeloDetail(new VeloDetail());
        Sonic.getVeloDetail().setId(7);

        List<Velo> velos = List.of(Flash, Sonic);

        //Définition du comportement du mock
        when(veloRepository.existsById(1)).thenReturn(true);
        when(veloRepository.findByIdGreaterThanOrderByTailleAsc(1)).thenReturn(velos);


        //Appel de la méthode à tester
        List<Velo> resultat = veloServiceImplUnderTest.findByIdGreaterThanOrderByTailleAsc(1);

        //Vérification du résultat
        assertEquals(velos, resultat);


    }
    @Test
    @DisplayName("findByIdGreaterThan1OrderByTailleAsc() retourne une liste vide")
    void findByIdGreaterThan1OrderByTailleAscListeVide() {
        //Création d'un Velo
        List<Velo> velos = List.of();

        //Définition du comportement du mock
        when(veloRepository.existsById(1)).thenReturn(true);
        when(veloRepository.findByIdGreaterThanOrderByTailleAsc(1)).thenReturn(velos);

        //Appel de la méthode à tester
        List<Velo> resultat = veloServiceImplUnderTest.findByIdGreaterThanOrderByTailleAsc(1);

        //Vérification du résultat
        assertEquals(velos, resultat);

    }

    @Test
    @DisplayName("findByNameStartingWithS() retourne une liste de velos dont le nom commence par S")
    void findByNameStartingWithS() {
        //Création d'un Velo
        Velo Sakura = new Velo();
        Sakura.setId(1);
        Sakura.setNom("Velo1");
        Sakura.setVeloDetail(new VeloDetail());
        Sakura.getVeloDetail().setId(1);

        Velo Sonic = new Velo();
        Sonic.setId(2);
        Sonic.setNom("Velo2");
        Sonic.setVeloDetail(new VeloDetail());
        Sonic.getVeloDetail().setId(2);

        List<Velo> velos = List.of(Sakura, Sonic);

        //Définition du comportement du mock
        when(veloRepository.findByNomStartingWith("S")).thenReturn(velos);

        //Appel de la méthode à tester
        List<Velo> resultat = veloServiceImplUnderTest.findByNameStartingWith("S");

        //Vérification du résultat
        assertEquals(velos, resultat);

    }

    @Test
    @DisplayName("findByNameStartingWithS() retourne une liste vide")
    void findByNameStartingWithSListeVide() {
        //Création d'un Velo
        List<Velo> velos = List.of();

        //Définition du comportement du mock
        when(veloRepository.findByNomStartingWith("S")).thenReturn(velos);

        //Appel de la méthode à tester
        List<Velo> resultat = veloServiceImplUnderTest.findByNameStartingWith("S");

        //Vérification du résultat
        assertEquals(velos, resultat);

    }
}