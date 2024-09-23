package com.example.tpfinsessiongestionvelo.repository;

import com.example.tpfinsessiongestionvelo.entities.Location;
import com.example.tpfinsessiongestionvelo.entities.Velo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    boolean existsByClientId(int id);

    List<Location> findAllByClientId(int id);

    List<Location> findLocationByIdGreaterThanOrderByIdDesc(int id);
}
