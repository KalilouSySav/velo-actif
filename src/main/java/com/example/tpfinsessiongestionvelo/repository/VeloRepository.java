package com.example.tpfinsessiongestionvelo.repository;

import com.example.tpfinsessiongestionvelo.entities.Velo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeloRepository extends JpaRepository<Velo, Integer> {

    List<Velo> findByIdGreaterThanOrderByTailleAsc(int id);

    List<Velo> findAllByOrderByNomAsc();

    List<Velo> findByNomStartingWith(String pattern);
}
