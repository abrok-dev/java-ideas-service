package com.step.demo.dto;

public class TargetAudienceIndexDto {
    public Long id;
    public String name;
    public int sortingList;
    public String initiativeTypeName;
    public String hint;

    public TargetAudienceIndexDto(Long id, String name, int sortingList, String initiativeTypeName, String hint) {
        this.id = id;
        this.name = name;
        this.sortingList = sortingList;
        this.initiativeTypeName = initiativeTypeName;
        this.hint = hint;
    }
}
