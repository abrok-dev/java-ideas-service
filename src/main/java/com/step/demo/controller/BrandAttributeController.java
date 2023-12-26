package com.step.demo.controller;

import com.step.demo.dto.BrandAttributeAdminIndexDto;
import com.step.demo.dto.BrandAttributeSaveDto;
import com.step.demo.dto.BrandAttributeShowDto;
import com.step.demo.entities.BrandAttribute;
import com.step.demo.entities.InitiativeType;
import com.step.demo.mappers.BrandAttributeIndexMapper;
import com.step.demo.mappers.BrandAttributeSaveMapper;
import com.step.demo.mappers.BrandAttributeShowMapper;
import com.step.demo.services.BrandAttributeService;
import com.step.demo.validation.EntityExists;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("api/v1/brand_attributes")
public class BrandAttributeController {

    @Autowired
    private BrandAttributeService service;

    @GetMapping("/")
    @PreAuthorize("hasAnyAuthority(T(com.step.demo.entities.PermissionEnum).BRAND_ATTRIBUTE_INDEX)")
    @Operation(summary = "Список атрибутов бренда", description = "Список атрибутов бренда")
    public Page<BrandAttributeAdminIndexDto> adminIndex(
            @RequestParam(value = "initiativeTypeId", required = false)
            @EntityExists(entityClass = InitiativeType.class) @Min(value = 1) Long initiativeTypeId,
            @RequestParam(value = "sort", required = false)
            @Parameter(description = "поле сортировки") String sort,
            @RequestParam(value = "order", required = false) String order,
            @RequestParam("page") @Min(0) int page,
            @RequestParam("limit") @Min(10) @Max(200) int limit

    ) {
        return service.index(sort, Sort.Direction.fromString(order),initiativeTypeId, page, limit);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority(T(com.step.demo.entities.PermissionEnum).BRAND_ATTRIBUTE_INDEX)")
    public BrandAttributeShowDto show(@PathVariable Long id) {
        BrandAttribute brandAttribute = service.show(id);
        if (brandAttribute == null) {
            return null;
        }

        return BrandAttributeShowMapper.toDtoShow(brandAttribute);
    }

    @PostMapping("/")
    @PreAuthorize("hasAnyAuthority(T(com.step.demo.entities.PermissionEnum).BRAND_ATTRIBUTE_SAVE) || hasAnyRole('admin')")
    public String save(@Valid @RequestBody BrandAttributeSaveDto brandAttribute) {
        BrandAttribute brandAttributeEntity = BrandAttributeSaveMapper.toEntity(brandAttribute);
        BrandAttribute brandAttributeResult = service.save(brandAttributeEntity);

        return Objects.toString(brandAttributeResult.getId());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority(T(com.step.demo.entities.PermissionEnum).BRAND_ATTRIBUTE_SAVE) || hasAnyRole('admin')")
    public String update(@Valid @RequestBody BrandAttributeSaveDto brandAttributeSaveDto, @PathVariable Long id) {
        BrandAttribute brandAttribute = BrandAttributeSaveMapper.toEntity(brandAttributeSaveDto);
        brandAttribute.setId(id);
        brandAttribute = service.update(brandAttribute);
        return Objects.toString(brandAttribute.getId());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority(T(com.step.demo.entities.PermissionEnum).BRAND_ATTRIBUTE_DELETE) || hasAnyRole('admin')")
    public boolean delete (@PathVariable Long id) {
        service.delete(id);
        return true;
    }
}
