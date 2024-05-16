package com.step.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Event extends JpaRepository<Event, Long> {
}
