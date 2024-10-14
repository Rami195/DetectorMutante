package com.example.parcialds.validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ADNValidacion.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ADNValida {
    String message() default "La Secuencia de ADN ingresada NO ES VALIDA";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
