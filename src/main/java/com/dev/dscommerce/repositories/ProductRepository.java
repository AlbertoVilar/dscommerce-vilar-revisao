package com.dev.dscommerce.repositories;

import com.dev.dscommerce.dto.ProductDTO;
import com.dev.dscommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {



  @Query("SELECT obj " +
          "FROM Product obj " +
          "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%'))")
  Page<Product> findByName(String name, Pageable pageable);

}
