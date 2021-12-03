package com.example.pruebatecnica.service;

import com.example.pruebatecnica.jsonResponse.EntidadRest;
import com.example.pruebatecnica.exceptions.ErrorException;

import java.util.List;

public interface EntidadService {
    EntidadRest saveEntidad(EntidadRest entidadRest) throws ErrorException;

    List<EntidadRest> listAllEntidad() throws ErrorException;

    EntidadRest getEntidadById(Integer entidadId) throws ErrorException;

    String deleteEntidadById(Integer entidadId) throws ErrorException;
}
