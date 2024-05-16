package com.step.demo.services;

import com.step.demo.entities.Attribute;
import com.step.demo.repositories.AttributeRepository;
import org.springframework.stereotype.Service;

@Service
public class AttributeService {

    private AttributeRepository attributeRepository;

    public Attribute showForEdit(Long id) {
        return attributeRepository.getForEdit(id);
    }
}
