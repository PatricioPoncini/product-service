package com.services.ms.product.product_service.service;

import com.services.ms.product.product_service.model.dto.CreateProductRequest;
import com.services.ms.product.product_service.model.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse findById(Long id);
    List<ProductResponse> findAll();
    List<ProductResponse> findByCategoryId(Long categoryId);
    ProductResponse save(CreateProductRequest request);
    ProductResponse update(Long id, CreateProductRequest request);
}
