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
            context.buildConstraintViolationWithTemplate("El ADN no puede ser nulo")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            return false;
        }

        int size = dna.length;
        if (size == 0) {
            context.buildConstraintViolationWithTemplate("El ADN no puede estar vacío")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            return false;
        }

        for (String sequence : dna) {
            if (sequence == null || sequence.length() != size) {
                context.buildConstraintViolationWithTemplate("Todas las secuencias de ADN deben tener la misma longitud")
                        .addConstraintViolation()
                        .disableDefaultConstraintViolation();
                return false;
            }
            for (char c : sequence.toCharArray()) {
                if (VALID_CHARACTERS.indexOf(c) == -1) {
                    context.buildConstraintViolationWithTemplate("El ADN solo puede contener los caracteres A, G, T, C")
                            .addConstraintViolation()
                            .disableDefaultConstraintViolation();
                    return false;
                }
            }
        }

        return true;
    }


}
