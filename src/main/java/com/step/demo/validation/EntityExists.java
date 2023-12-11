package com.step.demo.validation;

import com.step.demo.entities.BaseEntity;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EntityExistsValidator.class)
public @interface EntityExists {
    String message() default "Entity does not exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Class<? extends BaseEntity> entityClass();
}