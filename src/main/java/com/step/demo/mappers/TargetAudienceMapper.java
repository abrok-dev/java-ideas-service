package com.step.demo.mappers;

import com.step.demo.dto.TargetAudienceSaveDto;
import com.step.demo.dto.TargetAudienceShowDto;
import com.step.demo.entities.InitiativeType;
import com.step.demo.entities.TargetAudience;

public class TargetAudienceMapper {
    public static TargetAudience toEntity(TargetAudienceSaveDto dto) {
        TargetAudience entity = new TargetAudience();

        entity.setName(dto.name);
        entity.setSortingList(dto.sortingList);
        entity.setHint(dto.hint);
        InitiativeType type = new InitiativeType();
        type.setId(dto.initiativeTypeId);
        entity.setInitiativeType(type);

        return entity;
    }

    public static TargetAudienceShowDto toDtoShow(TargetAudience targetAudience) {
        TargetAudienceShowDto dto = new TargetAudienceShowDto();
        dto.id = targetAudience.getId();
        dto.hint = targetAudience.getHint();
        dto.name = targetAudience.getName();
        dto.sortingList = targetAudience.getSortingList();
        dto.initiativeTypeName = targetAudience.getInitiativeType().getName();

        return dto;
    }

    private TargetAudienceMapper() {
    }
}
