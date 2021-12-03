package com.example.pruebatecnica.jsonResponse;

import com.example.pruebatecnica.entities.Entidad;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TipoDocumentoRest {

    private String code;

    private String name;

    private String description;

    private Boolean state;

    //private List<Entidad> entidads = new ArrayList<>();
}
