package com.example.tpfinsessiongestionvelo.service;

import com.example.tpfinsessiongestionvelo.entities.Velo;

import java.util.List;

public interface VeloService {
    boolean updateVelo(int id, Velo velo);

    boolean deleteVelo(int id);

    boolean saveVelo(Velo velo);

    List<Velo> findAllOrderByNameAsc();

    List<Velo> findByIdGreaterThanOrderByTailleAsc(int id);

    List<Velo> findByNameStartingWith(String pattern);
}
