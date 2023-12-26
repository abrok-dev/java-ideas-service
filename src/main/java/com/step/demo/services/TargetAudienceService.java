package com.step.demo.services;

import com.step.demo.dto.TargetAudienceIndexDto;
import com.step.demo.entities.BrandAttribute;
import com.step.demo.entities.BrandAttributeQuestion;
import com.step.demo.entities.TargetAudience;
import com.step.demo.repositories.InitiativeTypeRepository;
import com.step.demo.repositories.TargetAudienceRepository;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TargetAudienceService {

    private TargetAudienceRepository repository;
    private InitiativeTypeRepository initiativeTypeRepository;

    public TargetAudienceService(TargetAudienceRepository repository, InitiativeTypeRepository initiativeTypeRepository) {
        this.repository = repository;
        this.initiativeTypeRepository = initiativeTypeRepository;
    }

    public Page<TargetAudienceIndexDto> index(String sortField, Sort.Direction order, Long initiativeTypeId, int page, @DefaultValue(value = "100") int limit) {
        if (sortField == null) {
            sortField = "id";
        }

        if (order == null) {
            order = Sort.Direction.ASC;
        }
        Sort sort = Sort.by(order, sortField);

        if (initiativeTypeId == null) {
            return repository.getTargetAudienceForIndex(PageRequest.of(page, limit, sort));
        }

        return repository.getTargetAudienceByInitiativeTypeIdForIndex(initiativeTypeId, PageRequest.of(page, limit, sort));
    }

    public TargetAudience save(TargetAudience targetAudience) {
        targetAudience.setInitiativeType(initiativeTypeRepository.getReferenceById(targetAudience.getInitiativeType().getId()));
        return repository.save(targetAudience);
    }

    public TargetAudience show(Long targetAudienceId) {
        Optional<TargetAudience> targetAudience =  repository.findById(targetAudienceId);
        if (targetAudience.isPresent()) {
            return targetAudience.get();
        }

        return null;
    }

    public TargetAudience update(TargetAudience targetAudience) {
        targetAudience.setInitiativeType(initiativeTypeRepository.getReferenceById(targetAudience.getInitiativeType().getId()));

        return repository.save(targetAudience);
    }

    public boolean delete(Long targetAudienceId) {
        repository.deleteById(targetAudienceId);

        return true;
    }
}
