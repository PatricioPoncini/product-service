package com.services.ms.product.product_service.model.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateCategoryRequest {
    @NotEmpty(message = "The field 'name' cannot be empty or null")
    private String name;

    @NotEmpty(message = "The field 'description' cannot be empty or null")
    private String description;
}
