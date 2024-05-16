package com.step.demo.repositories;

import com.step.demo.entities.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {

    @Override
    Attribute getById(Long aLong);
    List<Attribute> findByUserId(Long userId);

    @Query("SELECT a FROM Attribute a JOIN FETCH EventType WHERE a.id = :id")
    Attribute getForEdit(Long id);
}
