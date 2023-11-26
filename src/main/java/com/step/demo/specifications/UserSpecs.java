package com.step.demo.specifications;

import com.step.demo.entities.Role_;
import com.step.demo.entities.User;
import com.step.demo.entities.User_;
import jakarta.persistence.criteria.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecs implements Specification<User> {

    private final User userEntity;
    private final List<Integer> roleIds;

    public UserSpecs(User userEntity, List<Integer> roleIds) {
        this.userEntity = userEntity;
        this.roleIds = roleIds;
    }

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (userEntity.getUsername() != null && !userEntity.getUsername().isEmpty()) {
            predicates.add(getStringPredicate(root.get(User_.USERNAME), userEntity.getUsername(), criteriaBuilder));
        }

        if (userEntity.getEmail() != null && !userEntity.getEmail().isEmpty()) {
            predicates.add(getStringPredicate(root.get(User_.EMAIL), userEntity.getEmail(), criteriaBuilder));
        }

        if (userEntity.getName() != null && !userEntity.getName().isEmpty()) {
            predicates.add(getStringPredicate(root.get(User_.NAME), userEntity.getName(), criteriaBuilder));
        }

        if (userEntity.getSurname() != null && !userEntity.getSurname().isEmpty()) {
            predicates.add(getStringPredicate(root.get(User_.SURNAME), userEntity.getSurname(), criteriaBuilder));
        }

        if (userEntity.getSecondName() != null && !userEntity.getSecondName().isEmpty()) {
            predicates.add(getStringPredicate(root.get(User_.SECOND_NAME), userEntity.getSecondName(), criteriaBuilder));
        }

        if (roleIds != null && !roleIds.isEmpty()) {
            predicates.add(criteriaBuilder.in(root.join("roles").get(Role_.ID)).in(roleIds));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private Predicate getStringPredicate(Expression<String> exp, @NotNull String value, CriteriaBuilder cb) {
        if (value.contains("%")) {
            return cb.like(exp, value);
        } else {
            return cb.equal(exp, value);
        }
    }
}
