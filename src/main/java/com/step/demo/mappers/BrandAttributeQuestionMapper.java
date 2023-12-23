package com.step.demo.mappers;

import com.step.demo.dto.BrandAttributeQuestionSaveDto;
import com.step.demo.entities.BrandAttributeQuestion;

public class BrandAttributeQuestionMapper {
    private BrandAttributeQuestionMapper() {
    }

    public static BrandAttributeQuestion toEntity(BrandAttributeQuestionSaveDto dto) {
        BrandAttributeQuestion question = new BrandAttributeQuestion();
        question.setName(dto.name);
        question.setSortingList(dto.sortingList);
        question.setId(dto.id);

        return question;
    }
}
