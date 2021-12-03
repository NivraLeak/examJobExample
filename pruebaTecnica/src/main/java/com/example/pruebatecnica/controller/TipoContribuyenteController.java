package com.example.pruebatecnica.controller;

import com.example.pruebatecnica.exceptions.ErrorException;
import com.example.pruebatecnica.jsonResponse.TipoContribuyenteRest;
import com.example.pruebatecnica.response.CommonResponse;
import com.example.pruebatecnica.service.TipoContribuyenteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/tipoContribuyente")
@CrossOrigin()
public class TipoContribuyenteController {
    @Autowired
    TipoContribuyenteService tipoContribuyenteService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getAll")
    @ApiOperation(value = "Get all TipoContribuyente", authorizations = { @Authorization(value="JWT") })
    public CommonResponse<List<TipoContribuyenteRest>> getAllTipoContribuyente() throws ErrorException {
        return new CommonResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",tipoContribuyenteService.listAllTipoContribuyente());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ApiOperation(value = "Save TipoContribuyente", authorizations = { @Authorization(value="JWT") })
    public CommonResponse<TipoContribuyenteRest> saveTipoContribuyenteById(@RequestBody TipoContribuyenteRest tipoContribuyenteRest) throws ErrorException{
        return new CommonResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",tipoContribuyenteService.saveTipoContribuyente(tipoContribuyenteRest));
    }


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("delete/{idTipoContribuyente}")
    @ApiOperation(value = "Delete TipoContribuyente", authorizations = { @Authorization(value="JWT") })
    public CommonResponse<String> deleteTipoContribuyenteById(@PathVariable Integer idTipoContribuyente) throws ErrorException{
        return new CommonResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",tipoContribuyenteService.deleteTipoContribuyenteById(idTipoContribuyente));
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{idTipoContribuyente}")
    @ApiOperation(value = "Get TipoContribuyente by Id", authorizations = { @Authorization(value="JWT") })
    public CommonResponse<TipoContribuyenteRest> getTipoContribuyenteById(@PathVariable Integer idTipoContribuyente) throws ErrorException{
        return new CommonResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",tipoContribuyenteService.getTipoContribuyenteById(idTipoContribuyente));
    }

}
