package com.services.ms.product.product_service.controller;

import com.services.ms.product.product_service.model.dto.CategoryResponse;
import com.services.ms.product.product_service.model.dto.CreateCategoryRequest;
import com.services.ms.product.product_service.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponse> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryResponse findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> save(@Valid @RequestBody CreateCategoryRequest request) {
        CategoryResponse response = categoryService.save(request);
        return ResponseEntity.created(URI.create("/api/category" + response.getId())).body(response);
    }
}
