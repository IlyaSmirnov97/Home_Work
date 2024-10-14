package com.example.pizza.repository;

import com.example.pizza.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

}