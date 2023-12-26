package com.step.demo.repositories;

import com.step.demo.entities.TargetAudience;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TargetAudienceRepository extends
        JpaRepository<TargetAudience, Long>,
        JpaSpecificationExecutor<TargetAudience>,
        PagingAndSortingRepository<TargetAudience, Long> {

}
