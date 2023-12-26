package com.step.demo.dto;

import com.step.demo.entities.InitiativeType;
import com.step.demo.validation.EntityExists;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public class TargetAudienceSaveDto {
    @Length(max = 255)
    @NotNull
    public String name;
    @NotNull
    public Integer sortingList;
    @NotNull
    @Length(max = 1000)
    public String hint;
    @NotNull
    @EntityExists(entityClass = InitiativeType.class)
    public Long initiativeTypeId;
}
