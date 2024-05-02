package com.step.demo.services;

import com.step.demo.entities.Initiative;
import com.step.demo.entities.InitiativeComment;
import com.step.demo.entities.Role;
import com.step.demo.entities.User;
import com.step.demo.repositories.InitiativeCommentRepository;
import com.step.demo.repositories.InitiativeRepository;
import com.step.demo.repositories.InitiativeStatusRepository;
import com.step.demo.repositories.InitiativeTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InitiativeService {

    private InitiativeRepository repository;
    private InitiativeTypeRepository initiativeTypeRepository;
    private InitiativeStatusRepository statusRepository;
    private InitiativeCommentRepository commentRepository;

    public InitiativeService(
            InitiativeRepository repository,
            InitiativeTypeRepository initiativeTypeRepository,
            InitiativeStatusRepository statusRepository,
            InitiativeCommentRepository commentRepository) {
        this.repository = repository;
        this.initiativeTypeRepository = initiativeTypeRepository;
        this.statusRepository = statusRepository;
        this.commentRepository = commentRepository;
    }

    @Transactional
    public Initiative createDraft(Initiative initiative, User user) {
        if (initiative.getInitiativeType() != null) {
            initiative.setInitiativeType(initiativeTypeRepository.getReferenceById(initiative.getInitiativeType().getId()));
        }
        initiative.setInitiativeStatus(statusRepository.getReferenceById(initiative.getInitiativeStatus().getId()));

        initiative = repository.save(initiative);

        if (initiative.getComment() != null) {
            InitiativeComment comment = new InitiativeComment();
            comment.setText(initiative.getComment());
            comment.setUser(user);
            comment.setUserRole(Role.AUTHOR);
            comment.setInitiative(initiative);
            commentRepository.save(comment);
        }

        return initiative;
    }

    public Initiative update() {
        return null;
    }
}
