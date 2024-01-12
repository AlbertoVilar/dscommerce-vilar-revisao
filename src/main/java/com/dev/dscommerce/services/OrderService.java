package com.dev.dscommerce.services;

import com.dev.dscommerce.dto.OrderDTO;
import com.dev.dscommerce.dto.ProductDTO;
import com.dev.dscommerce.dto.ProductMinDTO;
import com.dev.dscommerce.entities.Order;
import com.dev.dscommerce.entities.ProducMapper;
import com.dev.dscommerce.entities.Product;
import com.dev.dscommerce.repositories.OrderRepository;
import com.dev.dscommerce.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {

        //Optional<Product> result = repositry.findById(id); **findById sempre retorna o Optional da entidade passada;
        Order order = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não Encontrado"));
        return new OrderDTO(order);
    }

}
