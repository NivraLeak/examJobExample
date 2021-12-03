package com.example.pruebatecnica.controller;

import com.example.pruebatecnica.exceptions.ErrorException;
import com.example.pruebatecnica.jsonResponse.TipoDocumentoRest;
import com.example.pruebatecnica.response.CommonResponse;
import com.example.pruebatecnica.service.TipoDocumentoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/tipoDocumento")
public class TipoDocumentoController {
    @Autowired
    TipoDocumentoService tipoDocumentoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{idTipoDocumento}")
    public CommonResponse<TipoDocumentoRest> getTipoDocumentoById(@PathVariable Integer idTipoDocumento) throws ErrorException {
        return new CommonResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                tipoDocumentoService.getTipoDocumentoById(idTipoDocumento));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("delete/{idTipoDocumento}")
    public CommonResponse<String> deleteTipoDocumento(@PathVariable Integer idTipoDocumento) throws ErrorException {
        return new CommonResponse<>("Succes", String.valueOf(HttpStatus.OK),"OK",
                                        tipoDocumentoService.deleteTipoDocumentoById(idTipoDocumento));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getAll")
    @ApiOperation(value = "Get all TipoDocumento", authorizations = { @Authorization(value="JWT") })
    public CommonResponse<List<TipoDocumentoRest>> getAllTipoDocumento() throws ErrorException{
        return new CommonResponse<>("Succes",String.valueOf(HttpStatus.OK),"ok",
                tipoDocumentoService.listAllTipoDocumento());
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping()
    public CommonResponse<TipoDocumentoRest> saveTipoDocumento(@RequestBody @Validated TipoDocumentoRest tipoDocumentoRest ) throws  ErrorException{
        return new CommonResponse<>("Succes",String.valueOf(HttpStatus.OK),"ok",
                tipoDocumentoService.saveTipoDocumento(tipoDocumentoRest));
    }



}
