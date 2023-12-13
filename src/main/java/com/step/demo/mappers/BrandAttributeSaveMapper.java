package com.step.demo.mappers;

import com.step.demo.dto.BrandAttributeSaveDto;
import com.step.demo.entities.BrandAttribute;
import com.step.demo.entities.InitiativeType;
import org.springframework.stereotype.Component;

@Component
public class BrandAttributeSaveMapper {

    private BrandAttributeSaveMapper() {
    }
    public static BrandAttribute toEntity(BrandAttributeSaveDto brandAttributeDto) {
        BrandAttribute entity = new BrandAttribute();

        entity.setActivity(brandAttributeDto.activity);
        entity.setName(brandAttributeDto.name);
        entity.setSortingList(brandAttributeDto.sortingList);
        entity.setHint(brandAttributeDto.hint);
        entity.setHasQuestion(brandAttributeDto.hasQuestions);
        InitiativeType type = new InitiativeType();
        type.setId(brandAttributeDto.initiativeTypeId);
        entity.setInitiativeType(type);

        entity.setBrandAttributeQuestions(brandAttributeDto.questions.stream().map(BrandAttributeQuestionMapper::toEntity).toList());

        return entity;
    }
}
