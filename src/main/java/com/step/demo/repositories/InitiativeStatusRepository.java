package com.step.demo.repositories;

import com.step.demo.entities.InitiativeStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InitiativeStatusRepository extends JpaRepository<InitiativeStatus, Long> {
}
