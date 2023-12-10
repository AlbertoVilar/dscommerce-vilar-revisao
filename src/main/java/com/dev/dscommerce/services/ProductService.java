package com.dev.dscommerce.services;

import com.dev.dscommerce.dto.ProductDTO;
import com.dev.dscommerce.entities.Product;
import com.dev.dscommerce.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private ProductRepository repository;

    public ProductService(ProductRepository repositry) {
        this.repository = repositry;
    }
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        //Optional<Product> result = repositry.findById(id); **findById sempre retorna o Optional da entidade passada;
        Product product = repository.findById(id).get();
           return new ProductDTO(product);
    }

    public Page<ProductDTO> findByPage(Pageable pageable) {
        Page<Product> pages = repository.findAll(pageable);
        return pages.map(x -> new ProductDTO(x));
    }
}
