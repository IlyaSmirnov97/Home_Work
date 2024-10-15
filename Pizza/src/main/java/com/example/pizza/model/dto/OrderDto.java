package com.example.pizza.model.dto;

import com.example.pizza.model.Address;
import com.example.pizza.model.Customer;
import com.example.pizza.model.Order;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class OrderDto {
    private UUID id;
    private Customer customer;
    private Address address;
    private Timestamp order_date;
    private int price;
    private Order.OrderStatus status;
}
