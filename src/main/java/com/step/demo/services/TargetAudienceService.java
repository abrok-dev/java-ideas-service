package com.step.demo.services;

import com.step.demo.entities.TargetAudience;
import com.step.demo.repositories.TargetAudienceRepository;
import com.step.demo.specifications.BrandAttributeSpecs;
import com.step.demo.specifications.TargetAudienceSpecs;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TargetAudienceService {

    private TargetAudienceRepository repository;

    public TargetAudienceService(TargetAudienceRepository repository) {
        this.repository = repository;
    }

    public Page<TargetAudience> index(String sortField, Sort.Direction order, Long initiativeTypeId, int page, @DefaultValue(value = "100") int limit) {
        if (sortField == null) {
            sortField = "id";
        }

        if (order == null) {
            order = Sort.Direction.ASC;
        }
        Sort sort = Sort.by(order, sortField);

        return repository.findAll(new TargetAudienceSpecs(initiativeTypeId), PageRequest.of(page, limit, sort));

    }
}
