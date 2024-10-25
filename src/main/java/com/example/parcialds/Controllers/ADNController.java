package com.example.parcialds.Controllers;

import jakarta.validation.Valid;
import com.example.parcialds.dto.ADNRequest;
import com.example.parcialds.dto.ADNResponse;
import com.example.parcialds.Services.ADNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/mutant")

public class ADNController {
    @Autowired
    private ADNService adnService;

    @PostMapping("")
    public ResponseEntity<ADNResponse> checkMutant(@RequestBody @Valid ADNRequest dnaRequest) {
        // Determinar si el ADN es de un mutante llamando a un metodo en ADNService
        boolean isMutant = adnService.isMutant(dnaRequest.getDna()); // Debes tener un metodo que verifique si es mutante

        // Guarda el ADN y si es mutante en la base de datos
        adnService.saveDna(dnaRequest.getDna(), isMutant);  // Proveer ambos parámetros

        ADNResponse dnaResponse = new ADNResponse(isMutant);

        if (isMutant) {
            return ResponseEntity.ok(dnaResponse);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(dnaResponse);
        }
    }


}
