package com.example.pruebatecnica.jsonResponse;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EntidadRest {
    private String documentNumber;

    private String businessName;

    private String commercialName;

    private String address;

    private Integer phone;

    private Boolean state;

    private Integer idTipoDocumento;
    private Integer idTipoContribuyente;
}
