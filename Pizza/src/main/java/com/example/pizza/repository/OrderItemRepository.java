package com.example.pizza.repository;

import com.example.pizza.model.Order;
import com.example.pizza.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {
    Optional<OrderItem> findById(UUID id);
}
