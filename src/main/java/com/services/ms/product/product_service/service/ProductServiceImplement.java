package com.services.ms.product.product_service.service;

import com.services.ms.product.product_service.exceptions.CategoryNotFoundException;
import com.services.ms.product.product_service.exceptions.ProductNotFoundException;
import com.services.ms.product.product_service.mapper.CategoryMapper;
import com.services.ms.product.product_service.mapper.ProductMapper;
import com.services.ms.product.product_service.model.dto.CreateProductRequest;
import com.services.ms.product.product_service.model.dto.ProductResponse;
import com.services.ms.product.product_service.model.entity.Product;
import com.services.ms.product.product_service.repository.CategoryRepository;
import com.services.ms.product.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImplement implements ProductService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryMapper categoryMapper;

    @Override
    public ProductResponse findById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toProductResponse)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream().map(productMapper::toProductResponse).collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> findByCategoryId(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .map(productRepository::findAllByCategory)
                .map(products -> products.stream()
                        .map(productMapper::toProductResponse).collect(Collectors.toList()))
                .orElseThrow(CategoryNotFoundException::new);
    }

    @Override
    public ProductResponse save(CreateProductRequest request) {
        return categoryRepository.findById(request.getCategoryId()).map(category -> {
            Product product = new Product();
            product.setName(request.getName());
            product.setDescription(request.getDescription());
            product.setPrice(request.getPrice());
            product.setCategory(category);
            product.setStatus(Boolean.TRUE);
            return productRepository.save(product);
        })
                .map(productMapper::toProductResponse)
                .orElseThrow(CategoryNotFoundException::new);
    }

    @Override
    public ProductResponse update(Long id, CreateProductRequest request) {
        return productRepository.findById(id)
                .map(product -> categoryRepository.findById(request.getCategoryId()).map(category -> {
                    product.setName(request.getName());
                    product.setDescription(request.getDescription());
                    product.setPrice(request.getPrice());
                    product.setCategory(category);
                    return productRepository.save(product);
                }).orElseThrow(CategoryNotFoundException::new))
                .map(productMapper::toProductResponse)
                .orElseThrow(ProductNotFoundException::new);
    }
}
