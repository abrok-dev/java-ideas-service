package com.step.demo.dto;

import com.step.demo.entities.InitiativeType;
import com.step.demo.entities.User;
import com.step.demo.validation.EntityExists;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.List;

public class InitiativeSaveDto extends InitiativeSaveBaseDto {
    @NotNull
    @Length(max = 50)
    public String name;
    public Date expiredDate;
    @EntityExists(entityClass = InitiativeType.class)
    public Long initiativeTypeId;
    @Nullable
    @Length(max = 300)
    public String description;
    @Min(0)
    @NotNull
    public int authorRating;
    @NotNull
    @EntityExists(entityClass = User.class)
    public Long userId;
    @Nullable
    @Min(0)
    public int brandManagerRating;
    public int region;
    public List<BrandAttributeEstimatesSaveDto> brandAttributeEstimates;
    public List<TargetAudienceAnswerSaveDto> targetAudienceAnswers;
    @Nullable
    @Length(max = 500)
    public String comment;
    @Nullable
    @Max(4)
    public int currentStep;
}
