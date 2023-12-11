package com.step.demo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public class BrandAttributeQuestionSaveDto {
    @Max(255)
    @NotNull
    public String name;
    @NotNull
    public Integer sortingList;
}
