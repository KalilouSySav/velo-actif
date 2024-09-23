package com.example.tpfinsessiongestionvelo.service;

import com.example.tpfinsessiongestionvelo.entities.Location;

import java.util.List;

public interface LocationService {

    List<Location> findAllByClientId(int id);

    boolean deleteLocationById(int id);

    List<Location> findLocationByIdGreaterThanOrderByIdDesc(int id);
}
    