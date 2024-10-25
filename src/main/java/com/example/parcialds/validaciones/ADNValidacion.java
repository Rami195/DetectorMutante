package com.example.parcialds.validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class ADNValidacion implements ConstraintValidator<ADNValida,String[]>{

    private static final String VALID_CHARACTERS = "AGTC";

    @Override
    public void initialize(ADNValida constraintAnnotation) {
    }

    @Override
    public boolean isValid(String[] dna, ConstraintValidatorContext context) {
        if (dna == null) {
            return false;
        }

        int size = dna.length;
        if (size == 0) {
            return false;
        }

        for (String sequence : dna) {
            if (sequence == null || sequence.length() != size) {
                return false;
            }
            for (char c : sequence.toCharArray()) {
                if (VALID_CHARACTERS.indexOf(c) == -1) {
                    return false;
                }
            }
        }

        return true;
    }


}
