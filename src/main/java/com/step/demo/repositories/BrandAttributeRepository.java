package com.step.demo.repositories;

import com.step.demo.entities.BrandAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandAttributeRepository extends JpaRepository<BrandAttribute, Long> {

    Optional<BrandAttribute> findById(Long id);

}
