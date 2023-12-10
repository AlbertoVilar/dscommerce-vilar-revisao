package com.dev.dscommerce.repositories;

import com.dev.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositry extends JpaRepository<Product, Long> {
}
