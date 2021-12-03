package com.example.pruebatecnica.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponse {
    private String jwt;

    public AuthenticationResponse(String jwt){
        this.jwt = jwt;
    }
}
