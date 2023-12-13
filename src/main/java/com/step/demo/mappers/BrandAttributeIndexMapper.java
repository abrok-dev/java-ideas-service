package com.step.demo.mappers;

import com.step.demo.dto.BrandAttributeAdminIndexDto;
import com.step.demo.entities.BrandAttribute;
import org.springframework.stereotype.Component;

@Component
public class BrandAttributeIndexMapper {

    private BrandAttributeIndexMapper(){}

    public static BrandAttributeAdminIndexDto toDto(BrandAttribute brandAttribute) {
        BrandAttributeAdminIndexDto dto = new BrandAttributeAdminIndexDto();
        dto.id = brandAttribute.getId();
        dto.hint = brandAttribute.getHint();
        dto.initiativeTypeName = brandAttribute.getInitiativeType().getName();
        dto.name = brandAttribute.getName();
        dto.sortingList = brandAttribute.getSortingList();
        dto.questionCount = (long) brandAttribute.getBrandAttributeQuestions().size();

        return dto;
    }
}
