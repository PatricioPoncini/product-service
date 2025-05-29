package com.services.ms.product.product_service.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

// Se pueden hacer validaciones dentro de esta clase, facilitando el uso de datos.
// Entonces los datos dentro solamente serán utilizados si cumplen y pasan las validaciones que ponemos.
@Getter
@Builder
public class CreateProductRequest {
    @NotEmpty(message = "The field 'name' cannot be empty or null")
    private String name;

    @NotEmpty(message = "The field 'description' cannot be empty or null")
    private String description;

    @NotNull(message = "The field 'price' cannot be null")
    private BigDecimal price;

    @NotNull(message = "The field 'category_id' cannot be null")
    private Long categoryId;
}
