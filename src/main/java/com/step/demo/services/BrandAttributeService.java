package com.step.demo.services;

import com.step.demo.dto.BrandAttributeSaveDto;
import com.step.demo.entities.BrandAttribute;
import com.step.demo.entities.BrandAttributeQuestion;
import com.step.demo.repositories.BrandAttributeQuestionRepository;
import com.step.demo.repositories.BrandAttributeRepository;
import com.step.demo.specifications.BrandAttributeSpecs;
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
    private BrandAttributeQuestionRepository questionRepository;

    public BrandAttributeService(BrandAttributeRepository repository) {
        this.repository = repository;
    }

    public Page<BrandAttribute> index(String sortField, Sort.Direction order, Long initiativeTypeId, int page, @DefaultValue(value = "100") int limit) {
        if (sortField == null) {
            sortField = "id";
        }

        if (order == null) {
            order = Sort.Direction.ASC;
        }
        Sort sort = Sort.by(order, sortField);
        return repository.findAll(new BrandAttributeSpecs(initiativeTypeId), PageRequest.of(page, limit, sort));
    }

    @Transactional
    public Long save(BrandAttributeSaveDto brandAttribute) {
        List<BrandAttributeQuestion> questions = brandAttribute.questions.stream().map(questionDto -> {
                    BrandAttributeQuestion question = new BrandAttributeQuestion();
                    question.setName(questionDto.name);
                    question.setSortingList(questionDto.sortingList);
                    return question;
                }).toList();
       questionRepository.saveAll(questions);
        return Long.valueOf(1);
    }
}
