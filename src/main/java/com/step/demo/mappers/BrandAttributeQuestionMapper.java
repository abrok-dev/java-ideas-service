package com.step.demo.mappers;

import com.step.demo.dto.BrandAttributeQuestionSaveDto;
import com.step.demo.dto.BrandAttributeQuestionShowDto;
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

    public static BrandAttributeQuestionShowDto toDtoShow(BrandAttributeQuestion question) {
        BrandAttributeQuestionShowDto dto = new BrandAttributeQuestionShowDto();
        dto.name = question.getName();
        dto.id = question.getId();
        dto.sortingList = question.getSortingList();

        return dto;
    }
}
