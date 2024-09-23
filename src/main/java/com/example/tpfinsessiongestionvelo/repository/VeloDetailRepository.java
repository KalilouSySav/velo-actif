package com.example.tpfinsessiongestionvelo.repository;

import com.example.tpfinsessiongestionvelo.entities.Velo;
import com.example.tpfinsessiongestionvelo.entities.VeloDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeloDetailRepository extends JpaRepository<VeloDetail, Integer> {
    List<VeloDetail> findVeloDetailByPrixLocationBetween(double prixLocation1, double prixLocation2);
}
