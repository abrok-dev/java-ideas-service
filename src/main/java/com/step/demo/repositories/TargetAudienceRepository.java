package com.step.demo.repositories;

import com.step.demo.dto.TargetAudienceIndexDto;
import com.step.demo.entities.TargetAudience;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TargetAudienceRepository extends
        JpaRepository<TargetAudience, Long>,
        JpaSpecificationExecutor<TargetAudience>,
        PagingAndSortingRepository<TargetAudience, Long> {

    @Query(value = "SELECT new com.step.demo.dto.TargetAudienceIndexDto(t.id, t.name, t.sortingList, i.name, t.hint) from TargetAudience t" +
            " inner join InitiativeType i ON i.id = t.initiativeType.id"
    )
    Page<TargetAudienceIndexDto> getTargetAudienceForIndex(Pageable pageable);

    @Query(value = "SELECT new com.step.demo.dto.TargetAudienceIndexDto(t.id, t.name, t.sortingList, i.name, t.hint) from TargetAudience t" +
            " inner join InitiativeType i ON i.id = t.initiativeType.id where i.id = ?1"
    )
    Page<TargetAudienceIndexDto> getTargetAudienceByInitiativeTypeIdForIndex(Long initiativeTypeId, Pageable pageable);

}
