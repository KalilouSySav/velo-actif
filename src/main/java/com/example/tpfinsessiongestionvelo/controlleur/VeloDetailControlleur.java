package com.example.tpfinsessiongestionvelo.controlleur;

import com.example.tpfinsessiongestionvelo.entities.VeloDetail;
import com.example.tpfinsessiongestionvelo.service.VeloDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VeloDetailControlleur {
    private VeloDetailService veloDetailService;
    @Autowired
    public VeloDetailControlleur(VeloDetailService veloDetailService) {
        this.veloDetailService = veloDetailService;
    }

    @PutMapping("/veloDetail/{id}")
    public boolean updateVeloDetail(@PathVariable int id, @RequestBody VeloDetail veloDetail) {
        return veloDetailService.updateVeloDetail(id, veloDetail);
    }
    @GetMapping("/veloDetail/{prixLocation1}/{prixLocation2}")
    public List<VeloDetail> findVeloDetailByPrixLocationBetween(@PathVariable double prixLocation1,
                                               @PathVariable double prixLocation2) {
        return veloDetailService.findVeloDetailByPrixLocationBetween(prixLocation1, prixLocation2);
    }
}
