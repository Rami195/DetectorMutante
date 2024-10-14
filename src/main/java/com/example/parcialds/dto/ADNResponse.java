package com.example.parcialds.dto;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class ADNResponse {
    private boolean isMutant;

    public boolean isMutant() {
        return isMutant;
    }
}
