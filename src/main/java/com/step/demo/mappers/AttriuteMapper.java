package com.step.demo.mappers;

import com.step.demo.dto.AttributeDetailDto;
import com.step.demo.dto.EventTypeDTO;
import com.step.demo.entities.Attribute;
import com.step.demo.entities.EventType;

public class AttriuteMapper {
    public static AttributeDetailDto AttributeToDetailDto(Attribute attribute) {
        AttributeDetailDto attributeDetailDto = new AttributeDetailDto();
        attributeDetailDto.id = attribute.getId();
        attributeDetailDto.name = attribute.getName();
        attributeDetailDto.backGroundColor = attribute.getBackGroundColor();
        attributeDetailDto.isCanDecrease = attribute.getIsCanDecrease();
        attributeDetailDto.maxReachedValue = attribute.getMaxReachedValue();
        attributeDetailDto.speedOfDecrease = attribute.getSpeedOfDecrease();
        attributeDetailDto.score = attribute.getScore();

        for (EventType eventType: attribute.getEventTypes()) {
            EventTypeDTO eventTypeDto = new EventTypeDTO();
            eventTypeDto.id = eventType.getId();
            eventTypeDto.name = eventType.getName();
            eventTypeDto.increaseValue = eventType.getIncreaseValue();
            attributeDetailDto.eventTypes.add(eventTypeDto);
        }

        return attributeDetailDto;
    }
}
