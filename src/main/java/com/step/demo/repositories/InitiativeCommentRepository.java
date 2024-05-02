package com.step.demo.repositories;

import com.step.demo.entities.InitiativeComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InitiativeCommentRepository extends JpaRepository<InitiativeComment, Long> {
}
