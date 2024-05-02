package com.step.demo.dto;

import java.util.Date;
import java.util.List;

public abstract class InitiativeSaveBaseDto {

    public String name;

    public Date expiredDate;

    public Long initiativeTypeId;
    public String description;

    public int authorRating;

    public Long userId;

    public int brandManagerRating;
    public int region;
    public List<BrandAttributeEstimatesSaveDto> brandAttributeEstimates;
    public List<TargetAudienceAnswerSaveDto> targetAudienceAnswers;

    public String comment;

    public int currentStep;
}
