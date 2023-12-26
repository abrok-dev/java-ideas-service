package com.step.demo.repositories;

import com.step.demo.dto.BrandAttributeAdminIndexDto;
import com.step.demo.entities.BrandAttribute;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface BrandAttributeRepository extends
        PagingAndSortingRepository<BrandAttribute, Long>,
        JpaRepository<BrandAttribute, Long>,
        JpaSpecificationExecutor<BrandAttribute>

{
    @Query(value = "SELECT new com.step.demo.dto.BrandAttributeAdminIndexDto(b.id, b.name, b.sortingList, i.name, b.hint, COUNT(q)) from BrandAttribute b" +
            " inner join InitiativeType i ON i.id = b.initiativeType.id" +
            " left join BrandAttributeQuestion q ON q.brandAttribute.id = b.id group by b.id, b.name, b.sortingList, i.name, b.hint",
        countQuery = "SELECT count(1) from BrandAttribute b where b.deleted = false"
    )
    Page<BrandAttributeAdminIndexDto> getBrandAttributesForIndex(Pageable pageable);

    @Query(value = "SELECT new com.step.demo.dto.BrandAttributeAdminIndexDto(b.id, b.name, b.sortingList, i.name, b.hint, COUNT(q)) from BrandAttribute b" +
            " inner join InitiativeType i ON i.id = b.initiativeType.id" +
            " left join BrandAttributeQuestion q ON q.brandAttribute.id = b.id where i.id = ?1 group by b.id, b.name, b.sortingList, i.name, b.hint",
            countQuery = "SELECT count(1) from BrandAttribute b where b.deleted = false and b.initiativeType.id = ?1"
    )
    Page<BrandAttributeAdminIndexDto> findByInitiativeTypeId(@NotNull Long initiativeId, Pageable pageable);

    Optional<BrandAttribute> findById(@NotNull Long id);


//    @Query("SELECT b.id, b.name, b.sortingList, i.name, b.hint from BrandAttribute b" +
//            " inner join InitiativeType i ON i.id = b.initiativeType.id" +
//            " left join BrandAttributeQuestion q ON q.brandAttribute.id = b.id group by b.id, b.name, b.sortingList, i.name, b.hint")
//    List<Object> getBrandAttributesForIndex();
//    @Query("SELECT new com.step.demo.dto.BrandAttributeAdminIndexDto(b.id, b.name, b.sortingList, i.name, b.hint, COUNT(q)) from BrandAttribute b" +
//            " inner join InitiativeType i ON i.id = b.initiativeType.id" +
//            " left join BrandAttributeQuestion q ON q.brandAttribute.id = b.id group by b.id, b.name, b.sortingList, i.name, b.hint")
//    Page<BrandAttributeAdminIndexDto> getBrandAttributesForIndex(Pageable pageable);
//

    Page<BrandAttribute> findBrandAttributesByInitiativeType_Id(Long initiativeTypeId, Pageable pageable);
}
