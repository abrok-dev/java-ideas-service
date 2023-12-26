package com.step.demo.specifications;

import com.step.demo.entities.TargetAudience;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class TargetAudienceSpecs implements Specification<TargetAudience> {

    private Long initiativeTypeId;

    public TargetAudienceSpecs(Long initiativeTypeId) {
        this.initiativeTypeId = initiativeTypeId;
    }

    @Override
    public Predicate toPredicate(Root<TargetAudience> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (initiativeTypeId != null) {
            return criteriaBuilder.equal(root.get("initiative_type_id"), initiativeTypeId);
        }
        return null;
    }
}
