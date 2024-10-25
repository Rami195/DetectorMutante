package com.example.parcialds.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Arrays;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ADN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name="DNA", columnDefinition = "text")
    private String dna;

    private boolean isMutant;

    public void setDna(String[] dna){
        this.dna= Arrays.toString(dna);
    }
    public String[] getDnaArray(){
        return this.dna.replaceAll("\\[|]|\\s","").split(",");
    }
}
