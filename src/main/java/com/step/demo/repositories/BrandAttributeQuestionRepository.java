package com.step.demo.repositories;

import com.step.demo.entities.BrandAttributeQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandAttributeQuestionRepository extends JpaRepository<BrandAttributeQuestion, Long> {
    @Override
    <S extends BrandAttributeQuestion> S save(S entity);

    @Override
    <S extends BrandAttributeQuestion> List<S> saveAll(Iterable<S> entities);

    @Query(value = "select id from BrandAttributeQuestion where brandAttribute.id = ?1 and deleted = false")
    List<Long> getBrandAttributeQuestionIdsByBrandAttributeId(Long brandAttributeId);
}
