package com.example.tpfinsessiongestionvelo.service;

import com.example.tpfinsessiongestionvelo.entities.LigneLocation;
import com.example.tpfinsessiongestionvelo.repository.LigneLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneLocationServiceImpl implements LigneLocationService {
    private LigneLocationRepository ligneLocationRepository;
    @Autowired
    public LigneLocationServiceImpl(LigneLocationRepository ligneLocationRepository) {
        this.ligneLocationRepository = ligneLocationRepository;
    }

    @Override
    public List<LigneLocation> findLigneLocationByIdGreaterThen(int id) {
        List<LigneLocation> ligneLocations = null;
        if (id <= 0 || !ligneLocationRepository.existsById(id)) {
            return ligneLocations;
        }
        return ligneLocationRepository.findLigneLocationByIdGreaterThan(id);
    }

    @Override
    public List<LigneLocation> findAllOrderByTarifAsc() {
        return ligneLocationRepository.findAllByOrderByTarifAsc();
    }

    @Override
    public boolean deleteLigneLocationById(int id) {
        if (id <= 0 || !ligneLocationRepository.existsById(id)) {
            return false;
        }
        ligneLocationRepository.deleteById(id);
        return true;
    }
}
