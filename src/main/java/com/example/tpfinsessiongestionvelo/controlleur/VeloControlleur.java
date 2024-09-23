package com.example.tpfinsessiongestionvelo.controlleur;

import com.example.tpfinsessiongestionvelo.entities.Accessoire;
import com.example.tpfinsessiongestionvelo.entities.Velo;
import com.example.tpfinsessiongestionvelo.entities.VeloDetail;
import com.example.tpfinsessiongestionvelo.service.VeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VeloControlleur {
    private VeloService veloService;
    @Autowired
    public VeloControlleur(VeloService veloService) {
        this.veloService = veloService;
    }

    @PostMapping("/velo")
    public boolean saveVelo(@RequestBody Velo velo) {
        return veloService.saveVelo(velo);
    }
    @PutMapping("/velo/{id}")
    public boolean updateVelo(@PathVariable int id, @RequestBody Velo velo) {
        return veloService.updateVelo(id, velo);
    }
    @DeleteMapping("/velo/{id}")
    public boolean deleteVelo(@PathVariable int id) {
        return veloService.deleteVelo(id);
    }
    @GetMapping("/velo")
    public List<Velo> findAllOrderByNameAsc() {
        return veloService.findAllOrderByNameAsc();
    }
    @GetMapping("/velo/id/{id}")
    public List<Velo> findByIdGreaterThanOrderByTailleAsc(@PathVariable int id) {
        return veloService.findByIdGreaterThanOrderByTailleAsc(id);
    }
    @GetMapping("/velo/name/{pattern}")
    public List<Velo> findByNameStartingWith(@PathVariable String pattern) {
        return veloService.findByNameStartingWith(pattern);
    }

}
