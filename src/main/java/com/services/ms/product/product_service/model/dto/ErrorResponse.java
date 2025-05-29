package com.services.ms.product.product_service.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// Puedo agregar más campos, pero depende del requerimiento.
// Por ahora así de simple está bien.

@Getter
@Setter
@Builder
public class ErrorResponse {
    private String message;
    private List<String> errors;
}
