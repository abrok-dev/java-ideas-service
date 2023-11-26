package com.step.demo.specifications;

import com.step.demo.entities.BrandAttribute;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class BrandAttributeSpecs extends Specification<BrandAttribute> {
    @Override
    public Predicate toPredicate(Root<BrandAttribute> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
