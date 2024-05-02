package com.step.demo.mappers;

import com.step.demo.dto.InitiativeSaveDraftDto;
import com.step.demo.entities.Initiative;
import com.step.demo.entities.InitiativeStatus;
import com.step.demo.entities.InitiativeType;
import com.step.demo.entities.User;

public class InitiativeMapper {
    private InitiativeMapper() {
    }

    public static Initiative toEntityFromSaveDraftDto(InitiativeSaveDraftDto dto) {
        Initiative initiative = new Initiative();
        User author = new User();
        author.setId(dto.userId);

        initiative.setAuthor(author);
        initiative.setName(dto.name);
        initiative.setDescription(dto.description);
        if (dto.initiativeTypeId != null) {
            InitiativeType initiativeType = new InitiativeType();
            initiativeType.setId(dto.initiativeTypeId);
            initiative.setInitiativeType(initiativeType);
        }

        InitiativeStatus status = new InitiativeStatus();
        status.setId(InitiativeStatus.DRAFT);
        initiative.setInitiativeStatus(status);
        initiative.setComment(dto.comment);

        return initiative;
    }

}
