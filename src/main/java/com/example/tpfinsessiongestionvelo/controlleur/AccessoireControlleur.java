package com.example.tpfinsessiongestionvelo.controlleur;

import com.example.tpfinsessiongestionvelo.entities.Accessoire;
import com.example.tpfinsessiongestionvelo.service.AccessoireService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccessoireControlleur {
    private AccessoireService accessoireService;
    @Autowired
    public AccessoireControlleur(AccessoireService accessoireService) {
        this.accessoireService = accessoireService;
    }

    @PostMapping("/accessoire")
    public boolean saveAccessoire(@RequestBody Accessoire accessoire) {
        return accessoireService.saveAccessoire(accessoire);
    }
    @PutMapping("/accessoire/{id}")
    public boolean updateAccessoire(@PathVariable int id, @RequestBody Accessoire accessoire) {
        return accessoireService.updateAccessoire(id, accessoire);
    }

    @DeleteMapping("/accessoire/{id}")
    public boolean deleteAccessoireById(@PathVariable int id) {
        return accessoireService.deleteAccessoireById(id);
    }

    @GetMapping("/accessoire/id/{id}")
    public Accessoire findAccessoireById(@PathVariable int id) {
        return accessoireService.findAccessoireById(id);
    }
    @GetMapping("/accessoire/name/{name}")
    public List<Accessoire> findAccessoireByName(@PathVariable String name) {
        return accessoireService.findAccessoireByName(name);
    }
    @GetMapping("/accessoires")
    public List<Accessoire> findAll() {
        return accessoireService.findAll();
    }

}
