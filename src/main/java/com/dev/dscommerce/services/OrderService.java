package com.dev.dscommerce.services;

import com.dev.dscommerce.dto.OrderDTO;
import com.dev.dscommerce.dto.OrderItemDTO;
import com.dev.dscommerce.dto.ProductDTO;
import com.dev.dscommerce.dto.ProductMinDTO;
import com.dev.dscommerce.entities.*;
import com.dev.dscommerce.repositories.OrderItemRepository;
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

import java.time.Instant;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserService userService; // With this injection I can use the User Authenticated
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {

        //Optional<Product> result = repositry.findById(id); **findById sempre retorna o Optional da entidade passada;
        Order order = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não Encontrado"));
        authService.validateSelfOrAdmin(order.getClient().getId());
        return new OrderDTO(order);
    }

    //Saving order
    @Transactional
    public OrderDTO insertOrder(OrderDTO dto) {

        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WEITING_PAYMENT);

        User user = userService.authenticated();
        order.setClient(user);

        for (OrderItemDTO itemDTO : dto.getItems()) {

            Product product = productRepository.getReferenceById(itemDTO.getProductId());
            OrderItem orderItem = new OrderItem(order, product, itemDTO.getQuantity(), product.getPrice());

            order.getItems().add(orderItem);
        }
        repository.save(order);
        orderItemRepository.saveAll(order.getItems());
        return new OrderDTO(order);
    }
}
