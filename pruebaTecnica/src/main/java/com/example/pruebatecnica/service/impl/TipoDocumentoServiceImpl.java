package com.example.pruebatecnica.service.impl;

import com.example.pruebatecnica.entities.TipoDocumento;
import com.example.pruebatecnica.exceptions.ErrorException;
import com.example.pruebatecnica.exceptions.InternalServerErrorException;
import com.example.pruebatecnica.exceptions.NotFoundException;
import com.example.pruebatecnica.jsonResponse.TipoDocumentoRest;
import com.example.pruebatecnica.repository.TipoDocumentoRepository;
import com.example.pruebatecnica.service.TipoDocumentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public TipoDocumentoRest saveTipoDocumento(TipoDocumentoRest createTipoDocumentoRest) throws ErrorException {
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setState(createTipoDocumentoRest.getState());
        tipoDocumento.setCode(createTipoDocumentoRest.getCode());
        tipoDocumento.setDescription(createTipoDocumentoRest.getDescription());
        tipoDocumento.setName(createTipoDocumentoRest.getName());
        try {
            tipoDocumentoRepository.save(tipoDocumento);
        }catch (final Exception e){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","SAVE");
        }

        return getTipoDocumentoById(tipoDocumento.getId());
    }

    @Override
    public List<TipoDocumentoRest> listAllTipoDocumento() throws ErrorException {
        List<TipoDocumento> tipoDocumentoList = tipoDocumentoRepository.findAll();
        return tipoDocumentoList.stream().map(tipoDocumento -> modelMapper.map(tipoDocumento,TipoDocumentoRest.class))
                .collect(Collectors.toList());
    }

    @Override
    public TipoDocumentoRest getTipoDocumentoById(Integer idTipoDocumento) throws ErrorException {
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(idTipoDocumento)
                .orElseThrow(() -> new NotFoundException("SNOT-404-1","TIPOCONTRIBUYENTE_NOT_FOUND"));

        return modelMapper.map(tipoDocumento, TipoDocumentoRest.class);
    }

    @Override
    public String deleteTipoDocumentoById(Integer idTipoDocumento) throws ErrorException {
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(idTipoDocumento)
                .orElseThrow(() -> new NotFoundException("SNOT-404-1","TIPOCONTRIBUYENTE_NOT_FOUND"));
        try{
            tipoDocumentoRepository.delete(tipoDocumento);
        }catch (final Exception e){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","DELETE");
        }
        return "TIPODOCUMENTO_DELETED";
    }
}
