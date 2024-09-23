package com.example.tpfinsessiongestionvelo.service;

import com.example.tpfinsessiongestionvelo.entities.LigneLocation;

import java.util.List;

public interface LigneLocationService {

    List<LigneLocation> findLigneLocationByIdGreaterThen(int id);

    List<LigneLocation> findAllOrderByTarifAsc();

    boolean deleteLigneLocationById(int id);
}
