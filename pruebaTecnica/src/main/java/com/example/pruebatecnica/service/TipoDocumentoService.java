package com.example.pruebatecnica.service;

import com.example.pruebatecnica.jsonResponse.TipoDocumentoRest;
import com.example.pruebatecnica.exceptions.ErrorException;

import java.util.List;

public interface TipoDocumentoService {

    TipoDocumentoRest saveTipoDocumento(TipoDocumentoRest createTipoDocumentoRest) throws ErrorException;

    List<TipoDocumentoRest> listAllTipoDocumento() throws ErrorException;

    TipoDocumentoRest getTipoDocumentoById(Integer idTipoDocumento) throws ErrorException;

    String deleteTipoDocumentoById(Integer idTipoDocumento) throws ErrorException;

}
