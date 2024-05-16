package com.step.demo.dto;

import java.util.List;

public class AttributeDetailDto {
    public Long id;
    public String name;
    public String backGroundColor;
    public Double score;
    public Boolean isCanDecrease;
    public Double speedOfDecrease;
    public Double maxReachedValue;
    public Long userId;
    public List<EventTypeDTO> eventTypes;

    // Constructors, Getters, and Setters

    public AttributeDetailDto() {
    }

}
