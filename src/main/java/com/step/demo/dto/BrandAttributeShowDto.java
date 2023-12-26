package com.step.demo.dto;

import java.util.List;

public class BrandAttributeShowDto {
    public Long id;
    public String name;
    public int sortingList;
    public Long initiativeTypeId;
    public String hint;
    public List<BrandAttributeQuestionShowDto> questions;
    public boolean activity;
    public boolean hasQuestion;
}
