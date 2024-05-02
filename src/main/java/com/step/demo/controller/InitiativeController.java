package com.step.demo.controller;

import com.step.demo.dto.InitiativeSaveDraftDto;
import com.step.demo.entities.Initiative;
import com.step.demo.entities.User;
import com.step.demo.mappers.InitiativeMapper;
import com.step.demo.services.InitiativeService;
import jakarta.validation.Valid;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/initiative/")
public class InitiativeController {

    private InitiativeService service;

    public InitiativeController(InitiativeService service) {
        this.service = service;
    }

    @PostMapping("draft/")
    public Long createDraft(@Valid @RequestBody InitiativeSaveDraftDto dto, @AuthenticationPrincipal User user) {
        Initiative initiative = service.createDraft(InitiativeMapper.toEntityFromSaveDraftDto(dto), user);
        return initiative.getId();
    }
}
