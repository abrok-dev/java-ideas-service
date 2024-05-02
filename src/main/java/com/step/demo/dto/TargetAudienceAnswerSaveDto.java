package com.step.demo.dto;

import com.step.demo.entities.TargetAudience;
import com.step.demo.validation.EntityExists;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.Nullable;

public class TargetAudienceAnswerSaveDto {
    @Nullable
    public String comment;
    @EntityExists(entityClass = TargetAudience.class)
    @NotNull
    public Long targetAudienceId;
}
