package com.example.pruebatecnica.repository;

import com.example.pruebatecnica.entities.TipoContribuyente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoContribuyenteRepository extends JpaRepository<TipoContribuyente,Integer> {
}
