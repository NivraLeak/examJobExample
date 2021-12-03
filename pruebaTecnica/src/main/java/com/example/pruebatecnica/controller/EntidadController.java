package com.example.pruebatecnica.controller;

import com.example.pruebatecnica.exceptions.ErrorException;
import com.example.pruebatecnica.jsonResponse.EntidadRest;
import com.example.pruebatecnica.jsonResponse.TipoContribuyenteRest;
import com.example.pruebatecnica.response.CommonResponse;
import com.example.pruebatecnica.service.EntidadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "Entidades")
@RestController
@RequestMapping(path = "/api/Entidad")
public class EntidadController {

    @Autowired
    EntidadService entidadService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getAll")
    @ApiOperation(value = "Get all entidad", authorizations = { @Authorization(value="JWT") })
    public CommonResponse<List<EntidadRest>> getAllEntidad() throws ErrorException {
        return new CommonResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",entidadService.listAllEntidad());
    }


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    public CommonResponse<EntidadRest> saveEntidad(@RequestBody EntidadRest entidadRest) throws ErrorException{
        return new CommonResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",entidadService.saveEntidad(entidadRest));
    }


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("delete/{idEntidad}")
    public CommonResponse<String> deleteEntidadById(@PathVariable Integer idEntidad) throws ErrorException{
        return new CommonResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",entidadService.deleteEntidadById(idEntidad));
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{idEntidad}")
    public CommonResponse<EntidadRest> getEntidadById(@PathVariable Integer idEntidad) throws ErrorException{
        return new CommonResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",entidadService.getEntidadById(idEntidad));
    }
}
