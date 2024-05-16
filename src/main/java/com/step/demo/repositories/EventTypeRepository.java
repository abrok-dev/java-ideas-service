package com.step.demo.repositories;

import com.step.demo.entities.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTypeRepository extends JpaRepository<EventType, Long> {
    @Override
    EventType getById(Long aLong);
}
