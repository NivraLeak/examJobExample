package com.example.pruebatecnica.service;

import com.example.pruebatecnica.jsonResponse.TipoContribuyenteRest;
import com.example.pruebatecnica.exceptions.ErrorException;

import java.util.List;

public interface TipoContribuyenteService {

    TipoContribuyenteRest saveTipoContribuyente(TipoContribuyenteRest tipoContribuyenteRest) throws ErrorException;

    List<TipoContribuyenteRest> listAllTipoContribuyente() throws  ErrorException;

    TipoContribuyenteRest getTipoContribuyenteById(Integer idTipoContribuyente) throws ErrorException;

    String deleteTipoContribuyenteById(Integer idTipoContribuyente) throws ErrorException;
}
