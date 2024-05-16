package com.step.demo.controller;

import com.step.demo.dto.AttributeDetailDto;
import com.step.demo.entities.Attribute;
import com.step.demo.mappers.AttriuteMapper;
import com.step.demo.services.AttributeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/attributes")
public class AttributeController {
    private AttributeService service;

    @GetMapping("/{id}")
    public AttributeDetailDto show(@PathVariable Long id) {
        Attribute attribute = service.showForEdit(id);

        return AttriuteMapper.AttributeToDetailDto(attribute);
    }

//    public Long create() {}
}
