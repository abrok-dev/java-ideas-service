package com.step.demo.mappers;

import com.step.demo.dto.BrandAttributeShowDto;
import com.step.demo.entities.BrandAttribute;

public class BrandAttributeShowMapper {
    private BrandAttributeShowMapper() {
    }

    public static BrandAttributeShowDto toDtoShow(BrandAttribute brandAttribute) {
        BrandAttributeShowDto dto = new BrandAttributeShowDto();
        dto.id = brandAttribute.getId();
        dto.hint = brandAttribute.getHint();
        dto.name = brandAttribute.getName();
        dto.initiativeTypeId = brandAttribute.getInitiativeType().getId();
        dto.activity = brandAttribute.isActivity();
        dto.sortingList = brandAttribute.getSortingList();
        dto.hasQuestion = brandAttribute.isHasQuestion();
        dto.questions = brandAttribute.getBrandAttributeQuestions().stream().map(BrandAttributeQuestionMapper::toDtoShow).toList();

        return dto;
    }
}
