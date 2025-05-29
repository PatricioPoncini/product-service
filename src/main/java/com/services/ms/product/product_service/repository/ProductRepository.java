package com.services.ms.product.product_service.repository;

import com.services.ms.product.product_service.model.entity.Category;
import com.services.ms.product.product_service.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository pone a disposición métodos para consultas, paginación, ordenamiento, etc.
// Esto es suficiente para poder hacer consultas en la DB, pero también se le pueden agregar métodos personalizados
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory(Category category);
}
