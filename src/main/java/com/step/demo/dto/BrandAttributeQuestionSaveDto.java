package com.step.demo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.Nullable;

public class BrandAttributeQuestionSaveDto {
    @Nullable
    public Long id;
    @Max(255)
    @NotNull
    public String name;
    @NotNull
    public Integer sortingList;
}
