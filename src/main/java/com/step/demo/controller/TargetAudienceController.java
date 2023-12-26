package com.step.demo.controller;

import com.step.demo.dto.TargetAudienceIndexDto;
import com.step.demo.dto.TargetAudienceSaveDto;
import com.step.demo.dto.TargetAudienceShowDto;
import com.step.demo.entities.TargetAudience;
import com.step.demo.mappers.TargetAudienceMapper;
import com.step.demo.services.TargetAudienceService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("api/v1/target_audience")
public class TargetAudienceController {

    private TargetAudienceService service;

    public TargetAudienceController(TargetAudienceService service) {
        this.service = service;
    }

    @GetMapping("/")
    @PreAuthorize("hasAnyAuthority(T(com.step.demo.entities.PermissionEnum).TARGET_AUDIENCE_INDEX) || hasAnyRole('admin')")
    public Page<TargetAudienceIndexDto> index(
            @RequestParam(value = "initiativeTypeId", required = false) @Min(value = 1) Long initiativeTypeId,
            @RequestParam(value = "sort", required = false ) String sort,
            @RequestParam(value = "order", required = false) String order,
            @RequestParam("page") @Min(0) int page,
            @RequestParam("limit") @Min(10) @Max(200) int limit
    ) {
        return service.index(sort, Sort.Direction.fromString(order), initiativeTypeId, page, limit);
    }

    @PostMapping("/")
    @PreAuthorize("hasAnyAuthority(T(com.step.demo.entities.PermissionEnum).TARGET_AUDIENCE_SAVE) || hasAnyRole('admin')")
    public String save(@RequestBody @Valid TargetAudienceSaveDto dto) {
        TargetAudience targetAudience = TargetAudienceMapper.toEntity(dto);
        targetAudience = service.save(targetAudience);
        return Objects.toString(targetAudience.getId());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority(T(com.step.demo.entities.PermissionEnum).TARGET_AUDIENCE_SAVE) || hasAnyRole('admin')")
    public String update(@RequestBody @Valid TargetAudienceSaveDto dto, @PathVariable() Long id) {
        TargetAudience targetAudience = TargetAudienceMapper.toEntity(dto);
        targetAudience.setId(id);

        targetAudience = service.update(targetAudience);

        return Objects.toString(targetAudience.getId());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority(T(com.step.demo.entities.PermissionEnum).TARGET_AUDIENCE_INDEX) || hasAnyRole('admin')")
    public TargetAudienceShowDto show(@PathVariable Long id) {
        TargetAudience targetAudience = service.show(id);
        if (targetAudience == null) {
            return null;
        }

        return TargetAudienceMapper.toDtoShow(targetAudience);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority(T(com.step.demo.entities.PermissionEnum).TARGET_AUDIENCE_DELETE) || hasAnyRole('admin')")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
