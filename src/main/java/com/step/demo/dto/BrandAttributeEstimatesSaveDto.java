package com.step.demo.dto;

import com.step.demo.entities.BrandAttribute;
import com.step.demo.validation.EntityExists;
import jakarta.validation.constraints.NotNull;

public class BrandAttributeEstimatesSaveDto {
    @NotNull
    public int estimate;
    @EntityExists(entityClass = BrandAttribute.class)
    public Long brandAttributeId;
}
