package com.example.tpfinsessiongestionvelo.service;

import com.example.tpfinsessiongestionvelo.entities.VeloDetail;

import java.util.List;

public interface VeloDetailService {
    boolean updateVeloDetail(int id, VeloDetail veloDetail);

    List<VeloDetail> findVeloDetailByPrixLocationBetween(double prixLocation1, double prixLocation2);
}
