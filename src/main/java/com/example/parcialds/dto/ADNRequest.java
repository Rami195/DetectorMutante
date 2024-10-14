package com.example.parcialds.dto;


import com.example.parcialds.validaciones.ADNValida;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ADNRequest {

    @ADNValida
    private String[] dna;


}
