package com.services.ms.product.product_service.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {
    PRODUCT_NOT_FOUND("Product not found"),
    INVALID_PRODUCT_PARAMETERS("Invalid product parameters"),

    CATEGORY_NOT_FOUND("Category not found"),
    INVALID_CATEGORY_PARAMETERS("Invalid category parameters"),

    INTERNAL_SERVER_ERROR("Internal server error");

    private final String message;

    ErrorCatalog(String message) {
        this.message = message;
    }
}
