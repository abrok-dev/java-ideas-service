package com.step.demo.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/target_audience")
public class TargetAudienceController {

    public void index(
            @RequestParam(value = "initiativeTypeId", required = false) @Min(value = 1) Long initiativeTypeId,
            @RequestParam(value = "sort", required = false ) String sort,
            @RequestParam(value = "order", required = false) String order,
            @RequestParam("page") @Min(1) int page,
            @RequestParam("limit") @Min(10) @Max(200) int limit
    ) {

    }
}
