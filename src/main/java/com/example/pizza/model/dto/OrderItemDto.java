package com.example.pizza.model.dto;

import com.example.pizza.model.Order;
import com.example.pizza.model.OrderItem;
import com.example.pizza.model.Pizza;
import lombok.Data;

import java.util.UUID;

@Data
public class OrderItemDto {
    private UUID id;
    private Order order;
    private Pizza pizza;
    private int quantity;
    private OrderItem.OrderItemStatus status;
}
