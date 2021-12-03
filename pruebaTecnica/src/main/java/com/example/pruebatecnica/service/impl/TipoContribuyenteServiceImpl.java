package com.example.pruebatecnica.service.impl;
import com.example.pruebatecnica.entities.TipoContribuyente;
import com.example.pruebatecnica.exceptions.ErrorException;
import com.example.pruebatecnica.exceptions.InternalServerErrorException;
import com.example.pruebatecnica.exceptions.NotFoundException;
import com.example.pruebatecnica.jsonResponse.TipoContribuyenteRest;
import com.example.pruebatecnica.repository.TipoContribuyenteRepository;
import com.example.pruebatecnica.service.TipoContribuyenteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoContribuyenteServiceImpl implements TipoContribuyenteService {
    @Autowired
    private TipoContribuyenteRepository tipoContribuyenteRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public TipoContribuyenteRest saveTipoContribuyente(TipoContribuyenteRest tipoContribuyenteRest) throws ErrorException {
        TipoContribuyente tipoContribuyente = new TipoContribuyente();
        tipoContribuyente.setState(tipoContribuyenteRest.getState());
        tipoContribuyente.setName(tipoContribuyenteRest.getName());
        try {
            tipoContribuyenteRepository.save(tipoContribuyente);
        }catch (final Exception e){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","SAVE");
        }
        return modelMapper.map(getTipoContribuyenteById(tipoContribuyente.getId()),TipoContribuyenteRest.class);
    }

    @Override
    public List<TipoContribuyenteRest> listAllTipoContribuyente() throws ErrorException {
        List<TipoContribuyente> tipoContribuyenteList = tipoContribuyenteRepository.findAll();

        return tipoContribuyenteList.stream().map(tipoContribuyente -> modelMapper.map(tipoContribuyente,TipoContribuyenteRest.class))
                .collect(Collectors.toList());
    }

    @Override
    public TipoContribuyenteRest getTipoContribuyenteById(Integer idTipoContribuyente) throws ErrorException {
        TipoContribuyente tipoContribuyente = tipoContribuyenteRepository.findById(idTipoContribuyente)
                .orElseThrow(() -> new NotFoundException("SNOT-404-1","TIPOCONTRIBUYENTE_NOT_FOUND"));
        return modelMapper.map(tipoContribuyente, TipoContribuyenteRest.class);
    }

    @Override
    public String deleteTipoContribuyenteById(Integer idTipoContribuyente) throws ErrorException {
        TipoContribuyente tipoContribuyente = tipoContribuyenteRepository.findById(idTipoContribuyente)
                .orElseThrow(()-> new NotFoundException("SNOT-404-1","TIPOCONTRIBUYENTE_NOT_FOUND"));
        try {
            tipoContribuyenteRepository.delete(tipoContribuyente);
        }catch (final Exception e){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","DELETE");
        }
        return "TIPOCONTRIBUYENTE_DELETED";
    }
}
