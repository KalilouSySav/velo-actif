package com.example.tpfinsessiongestionvelo.repository;

import com.example.tpfinsessiongestionvelo.entities.Client;
import com.example.tpfinsessiongestionvelo.entities.Velo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findClientByPrenomOrderByNomAsc(String name);

    List<Client> findAllByOrderByNomDesc();

    List<Client> findClientByIdLessThan(int id);
}

// C# entity framework linq