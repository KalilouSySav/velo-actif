package com.example.tpfinsessiongestionvelo.repository;

import com.example.tpfinsessiongestionvelo.entities.Accessoire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccessoireRepository extends JpaRepository<Accessoire, Integer> {
    List<Accessoire> findByNomContaining(String name);
}
