package com.services.ms.product.product_service.service;

import com.services.ms.product.product_service.exceptions.CategoryNotFoundException;
import com.services.ms.product.product_service.mapper.CategoryMapper;
import com.services.ms.product.product_service.model.dto.CategoryResponse;
import com.services.ms.product.product_service.model.dto.CreateCategoryRequest;
import com.services.ms.product.product_service.model.entity.Category;
import com.services.ms.product.product_service.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImplement implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponse findById(Long id) {
        return categoryRepository.findById(id).map(categoryMapper::toCategoryResponse).orElseThrow(CategoryNotFoundException::new);
    }

    @Override
    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll().stream().map(categoryMapper::toCategoryResponse).collect(Collectors.toList());
    }

    @Override
    public CategoryResponse save(CreateCategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toCategoryResponse(savedCategory);
    }
}
