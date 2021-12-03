package com.example.pruebatecnica.repository;

import com.example.pruebatecnica.entities.Entidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntidadRepository extends JpaRepository<Entidad,Integer> {
}
