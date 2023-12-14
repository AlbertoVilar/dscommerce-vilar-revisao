package com.dev.dscommerce.services;

import com.dev.dscommerce.dto.ProductDTO;
import com.dev.dscommerce.entities.ProducMapper;
import com.dev.dscommerce.entities.Product;
import com.dev.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {

        //Optional<Product> result = repositry.findById(id); **findById sempre retorna o Optional da entidade passada;
        Product product = repository.findById(id)
                     .orElseThrow(() -> new ResourceNotFoundException("Recurso não Encontrado"));
        return new ProductDTO(product);
    }

    public Page<ProductDTO> findByPage(Pageable pageable) {
        Page<Product> pages = repository.findAll(pageable);
        return pages.map(x -> new ProductDTO(x));
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findByName(String name, Pageable pageable) {
        Page<Product> pages = repository.findByName(name, pageable);
        return pages.map(x -> new ProductDTO(x));

    }

    @Transactional
    public ProductDTO insertProduct(ProductDTO dto) {

        Product entity = new Product();
        ProducMapper.copyDTOToProduct(dto, entity);
        entity = repository.save(entity);

        return new ProductDTO(entity);

    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {

        //Creating a Product by id referenced by JPA
        Product entity = repository.getReferenceById(id);

        ProducMapper.copyDTOToProduct(dto, entity);

        entity = repository.save(entity);
        return new ProductDTO(entity);

    }

    @Transactional
    public void deleteProduct(Long id) {
        repository.deleteById(id);

    }
}
