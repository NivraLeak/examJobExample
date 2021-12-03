package com.example.pruebatecnica.repository;

import com.example.pruebatecnica.entities.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento,Integer> {
}
