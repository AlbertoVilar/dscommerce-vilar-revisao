package com.dev.dscommerce.repositories;

import com.dev.dscommerce.entities.Order;
import com.dev.dscommerce.entities.User;
import com.dev.dscommerce.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
