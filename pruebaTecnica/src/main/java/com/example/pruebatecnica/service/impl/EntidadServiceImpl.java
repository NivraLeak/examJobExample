package com.example.pruebatecnica.service.impl;

import com.example.pruebatecnica.entities.Entidad;
import com.example.pruebatecnica.exceptions.InternalServerErrorException;
import com.example.pruebatecnica.exceptions.NotFoundException;
import com.example.pruebatecnica.jsonResponse.EntidadRest;
import com.example.pruebatecnica.repository.EntidadRepository;
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

    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public EntidadRest saveEntidad(EntidadRest entidadRest) throws ErrorException {
        Entidad entidadEntity;
        Entidad entidad = new Entidad();
        entidad.setAddress(entidadRest.getAddress());
        entidad.setBusinessName(entidadRest.getBusinessName());
        entidad.setCommercialName(entidadRest.getCommercialName());
        entidad.setDocumentNumber(entidadRest.getDocumentNumber());
        entidad.setPhone(entidadRest.getPhone());
        entidad.setState(entidadRest.getState());
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
