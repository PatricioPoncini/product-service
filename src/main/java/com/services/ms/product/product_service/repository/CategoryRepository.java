package com.services.ms.product.product_service.repository;

import com.services.ms.product.product_service.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository pone a disposición métodos para consultas, paginación, ordenamiento, etc.
// Esto es suficiente para poder hacer consultas en la DB, pero también se le pueden agregar métodos personalizados
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
