package com.services.ms.product.product_service.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

// No es necesario validaciones ya que esta clase se utilizará para devolver valores
@Getter
@Builder
public class CategoryResponse {
    private Long id;
    private String name;
    private String description;
}
