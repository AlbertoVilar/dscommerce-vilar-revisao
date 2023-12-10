package com.dev.dscommerce.services;

import com.dev.dscommerce.dto.ProductDTO;
import com.dev.dscommerce.entities.Product;
import com.dev.dscommerce.repositories.ProductRepositry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    private ProductRepositry repositry;

    public ProductService(ProductRepositry repositry) {
        this.repositry = repositry;
    }
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> result = repositry.findById(id);
        Product product = result.get();
        return new ProductDTO(product);
    }
}
