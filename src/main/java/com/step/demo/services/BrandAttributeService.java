package com.step.demo.services;

import com.step.demo.dto.BrandAttributeAdminIndexDto;
import com.step.demo.entities.BrandAttribute;
import com.step.demo.entities.BrandAttributeQuestion;
import com.step.demo.repositories.BrandAttributeQuestionRepository;
import com.step.demo.repositories.BrandAttributeRepository;
import com.step.demo.repositories.InitiativeTypeRepository;
import com.step.demo.specifications.BrandAttributeSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandAttributeService {

    private BrandAttributeRepository repository;
    private InitiativeTypeRepository initiativeTypeRepository;

    public BrandAttributeService(BrandAttributeRepository repository, InitiativeTypeRepository initiativeTypeRepository) {
        this.repository = repository;
        this.initiativeTypeRepository = initiativeTypeRepository;
    }

    public Page<BrandAttributeAdminIndexDto> index(String sortField, Sort.Direction order, Long initiativeTypeId, int page, @DefaultValue(value = "100") int limit) {
        if (sortField == null) {
            sortField = "id";
        }

        if (order == null) {
            order = Sort.Direction.ASC;
        }
        Sort sort = Sort.by(order, sortField);
        if (initiativeTypeId == null) {
            return repository.getBrandAttributesForIndex(PageRequest.of(page, limit, sort));
        }
        return repository.findByInitiativeTypeId(initiativeTypeId, PageRequest.of(page, limit, sort));
    }

    @Transactional
    public BrandAttribute save(BrandAttribute brandAttribute) {

        brandAttribute.setInitiativeType(initiativeTypeRepository.getReferenceById(brandAttribute.getInitiativeType().getId()));
        brandAttribute = repository.save(brandAttribute);
        return brandAttribute;
    }

    @Transactional
    public BrandAttribute update(BrandAttribute brandAttribute) {
        brandAttribute.setInitiativeType(initiativeTypeRepository.getReferenceById(brandAttribute.getInitiativeType().getId()));
        for (BrandAttributeQuestion question: brandAttribute.getBrandAttributeQuestions()) {
            question.setBrandAttribute(repository.getReferenceById(brandAttribute.getId()));
        }

        brandAttribute = repository.save(brandAttribute);
        return brandAttribute;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
