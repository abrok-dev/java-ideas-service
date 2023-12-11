package com.step.demo.repositories;


import com.step.demo.entities.InitiativeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InitiativeTypeRepository extends JpaRepository<InitiativeType, Long> {
    @Override
    <S extends InitiativeType> S save(S entity);
}
