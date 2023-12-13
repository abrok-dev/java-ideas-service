package com.step.demo.specifications;

import com.step.demo.entities.BrandAttribute;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class BrandAttributeSpecs implements Specification<BrandAttribute> {
    private Long initiativeTypeId;

    public BrandAttributeSpecs(Long initiativeTypeId) {
        this.initiativeTypeId = initiativeTypeId;
    }

    @Override
    public Predicate toPredicate(Root<BrandAttribute> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (initiativeTypeId != null) {
            return criteriaBuilder.equal(root.get("initiative_type_id"), initiativeTypeId);
        }
        return null;
    }
}
