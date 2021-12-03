package com.example.pruebatecnica.controller;

import com.example.pruebatecnica.exceptions.ErrorException;
import com.example.pruebatecnica.jsonResponse.TipoContribuyenteRest;
import com.example.pruebatecnica.response.CommonResponse;
import com.example.pruebatecnica.service.TipoContribuyenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/tipoContribuyente")
public class TipoContribuyenteController {
    @Autowired
    TipoContribuyenteService tipoContribuyenteService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getAll")
    public CommonResponse<List<TipoContribuyenteRest>> getAllTipoContribuyente() throws ErrorException {
        return new CommonResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",tipoContribuyenteService.listAllTipoContribuyente());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    public CommonResponse<TipoContribuyenteRest> saveTipoContribuyenteById(@RequestBody TipoContribuyenteRest tipoContribuyenteRest) throws ErrorException{
        return new CommonResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",tipoContribuyenteService.saveTipoContribuyente(tipoContribuyenteRest));
    }


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("delete/{idTipoContribuyente}")
    public CommonResponse<String> deleteTipoContribuyenteById(@PathVariable Integer idTipoContribuyente) throws ErrorException{
        return new CommonResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",tipoContribuyenteService.deleteTipoContribuyenteById(idTipoContribuyente));
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{idTipoContribuyente}")
    public CommonResponse<TipoContribuyenteRest> getTipoContribuyenteById(@PathVariable Integer idTipoContribuyente) throws ErrorException{
        return new CommonResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",tipoContribuyenteService.getTipoContribuyenteById(idTipoContribuyente));
    }

}
