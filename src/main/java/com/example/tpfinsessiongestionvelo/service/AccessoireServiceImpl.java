package com.example.tpfinsessiongestionvelo.service;

import com.example.tpfinsessiongestionvelo.entities.Accessoire;
import com.example.tpfinsessiongestionvelo.repository.AccessoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class AccessoireServiceImpl implements AccessoireService{
    private AccessoireRepository accessoireRepository;
    @Autowired
    public AccessoireServiceImpl(AccessoireRepository accessoireRepository) {
        this.accessoireRepository = accessoireRepository;
    }

    @Override
    public boolean saveAccessoire(Accessoire accessoire) {
        if (accessoire == null) {
            return false;
        }
        accessoireRepository.save(accessoire);
        return true;
    }

    @Override
    public boolean updateAccessoire(int id, Accessoire accessoire) {
        if (!accessoireRepository.existsById(id)) {
            return false;
        }
        accessoire.setId(id);
        accessoireRepository.save(accessoire);
        return true;
    }

    @Override
    public boolean deleteAccessoireById(int id) {
        if (!accessoireRepository.existsById(id)) {
            return false;
        }
        Accessoire accessoire = accessoireRepository.findById(id).get();
        accessoire.setSupprimer(true);
        accessoireRepository.save(accessoire);
        return true;
    }

    @Override
    public Accessoire findAccessoireById(int id) {
        Accessoire accessoire = null;
        if (!accessoireRepository.existsById(id)) {
            return accessoire;
        }
        accessoire = accessoireRepository.findById(id).get();
        return accessoire;
    }

    @Override
    public List<Accessoire> findAccessoireByName(String name) {
        List<Accessoire> accessoires = null;
        if (name == null) {
            return accessoires;
        }
        accessoires = accessoireRepository.findByNomContaining(name);
        return accessoires;
    }

    @Override
    public List<Accessoire> findAll() {
        return accessoireRepository.findAll();
    }
}
