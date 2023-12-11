package com.step.demo.dto;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class BrandAttributeAdminIndexDto {

    public Long id;
    public String name;
    public int sortingList;
    public String initiativeTypeName;
    public String hint;
    public int questionCount;

    public BrandAttributeAdminIndexDto(Long id, String name, int sortingList, String initiativeTypeName, String hint, int questionCount) {
        this.id = id;
        this.name = name;
        this.sortingList = sortingList;
        this.initiativeTypeName = initiativeTypeName;
        this.hint = hint;
        this.questionCount = questionCount;
    }
    public BrandAttributeAdminIndexDto() {
    }
}
