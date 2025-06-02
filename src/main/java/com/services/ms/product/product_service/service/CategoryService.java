package com.services.ms.product.product_service.service;

import com.services.ms.product.product_service.model.dto.CategoryResponse;
import com.services.ms.product.product_service.model.dto.CreateCategoryRequest;

import java.util.List;

public interface CategoryService {
    CategoryResponse findById(Long id);
    List<CategoryResponse> findAll();
    CategoryResponse save(CreateCategoryRequest request);
}
