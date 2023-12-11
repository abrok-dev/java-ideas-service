package com.step.demo.validation;

import com.step.demo.entities.BaseEntity;
import jakarta.persistence.EntityManager;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EntityExistsValidator implements ConstraintValidator<EntityExists, Long> {

    private final EntityManager entityManager;
    private Class<? extends BaseEntity> entityClass;

    public EntityExistsValidator(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void initialize(EntityExists constraintAnnotation) {
        entityClass = constraintAnnotation.entityClass();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return entityManager.find(entityClass, value) != null;
    }
}
