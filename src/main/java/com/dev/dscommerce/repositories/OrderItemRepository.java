package com.dev.dscommerce.repositories;

import com.dev.dscommerce.entities.Order;
import com.dev.dscommerce.entities.OrderItem;
import com.dev.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
