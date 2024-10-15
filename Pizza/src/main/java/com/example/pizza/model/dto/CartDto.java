package com.example.pizza.model.dto;

import com.example.pizza.model.Customer;
import lombok.Data;

import java.util.UUID;

@Data
public class CartDto {
    private UUID id;
    private Customer customer;
    private boolean isActive;
}
