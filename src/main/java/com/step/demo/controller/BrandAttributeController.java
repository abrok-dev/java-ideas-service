package com.step.demo.controller;

import com.step.demo.dto.BrandAttributeAdminIndexDto;
import com.step.demo.dto.BrandAttributeSaveDto;
import com.step.demo.entities.BrandAttribute;
import com.step.demo.mappers.BrandAttributeIndexMapper;
import com.step.demo.services.BrandAttributeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/brand_attributes")
public class BrandAttributeController {

    private BrandAttributeService service;

    @GetMapping("/")
    public Page<BrandAttributeAdminIndexDto> adminIndex(
            @RequestParam("initiativeTypeId") @Min(value = 1) Long initiativeTypeId,
            @RequestParam("sort") String sort,
            @RequestParam("order") String order,
            @RequestParam("page") @Min(1) int page,
            @RequestParam("limit") @Min(10) int limit

    ) {
        Page<BrandAttribute> brandAttributes = service.index(sort, Sort.Direction.fromString(order),initiativeTypeId, page, limit);

        return brandAttributes.map(BrandAttributeIndexMapper::toDto);
    }

    @PostMapping("/")
    public String save(@Valid BrandAttributeSaveDto brandAttribute) {

    }
}
