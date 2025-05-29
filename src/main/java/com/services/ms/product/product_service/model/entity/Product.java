package com.services.ms.product.product_service.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price; // BigDecimal --> mayor precisión

    // true o false (1 - 0) para MySQL --> https://dev.mysql.com/doc/connector-j/en/connector-j-reference-type-conversions.html
    @Column(columnDefinition = "BIT(1) DEFAULT 0")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
