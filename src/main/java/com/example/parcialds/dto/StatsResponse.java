package com.example.parcialds.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StatsResponse {

    @JsonProperty("Contador_mutantes")
    private long countMutantDna;

    @JsonProperty("Contador-humanos")
    private long countHumanDna;

    private double ratio;
}