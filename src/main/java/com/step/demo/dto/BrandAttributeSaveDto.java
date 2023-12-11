package com.step.demo.dto;

import com.step.demo.entities.InitiativeType;
import com.step.demo.validation.EntityExists;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class BrandAttributeSaveDto {

    @NotNull
    public boolean activity;

    @Max(255)
    @NotNull
    public String name;
    @NotNull
    public Integer sortingList;
    @NotNull
    @Max(1000)
    public String hint;
    @NotNull
    public boolean hasQuestions;

    @NotNull
    @EntityExists(entityClass = InitiativeType.class)
    public Long initiativeTypeId;

    @NotEmpty
    public List<BrandAttributeQuestionSaveDto> questions;
}
