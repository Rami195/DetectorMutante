package com.example.parcialds;

import com.example.parcialds.Services.ADNService;
import com.example.parcialds.entities.ADN;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ParcialDsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParcialDsApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ADNService ADNService) {
        return args -> {
            // Ejemplo de secuencia de ADN
            String[] dnaArray = {"AAAA", "CCGA", "TTAA", "AGAA"};
            String[] dnaArray2 = {"AAAAA", "CAGAA", "TTAAA", "AGAAA"};

            // Verificar si la secuencia de ADN es mutante
            boolean isMutant = ADNService.isMutant(dnaArray);
            System.out.println("Is mutant: " + isMutant);
            boolean isMutant1 = ADNService.isMutant(dnaArray2);
            System.out.println("Is mutant: " + isMutant1);

            // Guardar la secuencia de ADN en la base de datos
            ADN savedADN = ADNService.saveDna(dnaArray, isMutant);
            System.out.println("DNA saved: " + savedADN);
            ADN savedADN1 = ADNService.saveDna(dnaArray2, isMutant1);
            System.out.println("DNA saved: " + savedADN1);
        };
    }
}
