package com.example.tpfinsessiongestionvelo.controlleur;

import com.example.tpfinsessiongestionvelo.entities.LigneLocation;
import com.example.tpfinsessiongestionvelo.service.LigneLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LigneLocationControlleur {
    private LigneLocationService ligneLocationService;
    @Autowired
    public LigneLocationControlleur(LigneLocationService ligneLocationService) {
        this.ligneLocationService = ligneLocationService;
    }
    @GetMapping("/ligneLocation/{id}")
    public List<LigneLocation> findLigneLocationByIdGreaterThen(@PathVariable int id) {
        return ligneLocationService.findLigneLocationByIdGreaterThen(id);
    }
    @GetMapping("/ligneLocations")
    public List<LigneLocation> findAllOrderByTarifAsc() {
        return ligneLocationService.findAllOrderByTarifAsc();
    }
    @DeleteMapping("/ligneLocation/{id}")
    public boolean deleteLigneLocationById(@PathVariable int id) {
        return ligneLocationService.deleteLigneLocationById(id);
    }
}
