package com.example.pruebatecnica.service.impl;

import com.example.pruebatecnica.entities.Entidad;
import com.example.pruebatecnica.entities.TipoContribuyente;
import com.example.pruebatecnica.entities.TipoDocumento;
import com.example.pruebatecnica.exceptions.InternalServerErrorException;
import com.example.pruebatecnica.exceptions.NotFoundException;
import com.example.pruebatecnica.jsonResponse.EntidadRest;
import com.example.pruebatecnica.repository.EntidadRepository;
import com.example.pruebatecnica.repository.TipoContribuyenteRepository;
import com.example.pruebatecnica.repository.TipoDocumentoRepository;
import com.example.pruebatecnica.service.EntidadService;
import com.example.pruebatecnica.exceptions.ErrorException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntidadServiceImpl implements EntidadService {
    @Autowired
    private EntidadRepository entidadRepository;

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Autowired
    private TipoContribuyenteRepository tipoContribuyenteRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public EntidadRest saveEntidad(EntidadRest entidadRest) throws ErrorException {
        Entidad entidadEntity;
        Entidad entidad = new Entidad();
        final TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(entidadRest.getIdTipoDocumento())
                .orElseThrow(()-> new NotFoundException("SNOT-404-1","ID_TIPODOCUMENTO_NOT_FOUND"));
        final TipoContribuyente tipoContribuyente = tipoContribuyenteRepository.findById(entidadRest.getIdTipoContribuyente())
                .orElseThrow(()-> new NotFoundException("SNOT-404-1","ID_TIPOCONTRIBUYENTE_NOT_FOUND"));

        entidad.setAddress(entidadRest.getAddress());
        entidad.setBusinessName(entidadRest.getBusinessName());
        entidad.setCommercialName(entidadRest.getCommercialName());
        entidad.setDocumentNumber(entidadRest.getDocumentNumber());
        entidad.setPhone(entidadRest.getPhone());
        entidad.setState(entidadRest.getState());
        entidad.setTipoDocumento(tipoDocumento);
        entidad.setTipoContribuyente(tipoContribuyente);
        try{
            entidadEntity = entidadRepository.save(entidad);
        }catch (final Exception e){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","SAVE");
        }
        return modelMapper.map(getEntidadById(entidadEntity.getId()),EntidadRest.class);
    }

    @Override
    public List<EntidadRest> listAllEntidad() throws ErrorException {
        List<Entidad> listEntidad = entidadRepository.findAll();

        return listEntidad.stream().map(entidad -> modelMapper.map(entidad,EntidadRest.class))
                .collect(Collectors.toList());
    }

    @Override
    public EntidadRest getEntidadById(Integer entidadId) throws ErrorException {
        Entidad entidad = entidadRepository.findById(entidadId).orElseThrow(()-> new NotFoundException("SNOT-404-1","ENTIDAD_NOT_FOUND"));
        return modelMapper.map(entidad, EntidadRest.class);
    }

    @Override
    public String deleteEntidadById(Integer entidadId) throws ErrorException {
        Entidad entidad = entidadRepository.findById(entidadId).orElseThrow(()-> new NotFoundException("SNOT-404-1","ENTIDAD_NOT_FOUND"));
        try {
            entidadRepository.delete(entidad);
        }catch (final Exception e){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","DELETE");
        }
        return "ENTIDAD_DELETED";
    }
}
