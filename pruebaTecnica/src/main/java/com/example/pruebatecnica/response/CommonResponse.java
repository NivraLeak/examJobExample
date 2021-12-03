package com.example.pruebatecnica.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CommonResponse<T> implements Serializable {

    private static final long serialVersionUID=1L;

    private String status;
    private String code;
    private String message;
    private T data;

    public CommonResponse(String status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public CommonResponse(String status, String code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
