package com.example.tpfinsessiongestionvelo.service;

import com.example.tpfinsessiongestionvelo.entities.Accessoire;

import java.util.List;

public interface AccessoireService {

    boolean saveAccessoire(Accessoire accessoire);

    boolean updateAccessoire(int id, Accessoire accessoire);

    boolean deleteAccessoireById(int id);

    Accessoire findAccessoireById(int id);

    List<Accessoire> findAccessoireByName(String name);

    List<Accessoire> findAll();
}
