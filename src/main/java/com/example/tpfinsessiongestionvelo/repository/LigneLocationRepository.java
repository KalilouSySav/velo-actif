package com.example.tpfinsessiongestionvelo.repository;

import com.example.tpfinsessiongestionvelo.entities.LigneLocation;
import com.example.tpfinsessiongestionvelo.entities.Velo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneLocationRepository  extends JpaRepository<LigneLocation, Integer> {
    List<LigneLocation> findLigneLocationByIdGreaterThan(int id);

    List<LigneLocation> findAllByOrderByTarifAsc();
}
