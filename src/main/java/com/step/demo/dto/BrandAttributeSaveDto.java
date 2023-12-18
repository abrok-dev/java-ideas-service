package com.step.demo.dto;

import com.step.demo.entities.InitiativeType;
import com.step.demo.validation.EntityExists;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public class BrandAttributeSaveDto {

    @NotNull
    public boolean activity;

    @Length(max = 255)
    @NotNull
//    @Max(value = 3, message = "ERROR MAX")
    public String name;
    @NotNull
    public Integer sortingList;
    @NotNull
    @Length(max = 1000)
    public String hint;
    @NotNull
    public boolean hasQuestions;
    @NotNull
    @EntityExists(entityClass = InitiativeType.class)
    public Long initiativeTypeId;
    @NotEmpty
    public List<BrandAttributeQuestionSaveDto> questions;
}
