package com.example.pizza.model.dto;

import com.example.pizza.model.Cart;
import com.example.pizza.model.Pizza;
import lombok.Data;

import java.util.UUID;

@Data
public class CartItemDto {
    private UUID id;
    private Cart cart;
    private Pizza pizza;
    private int quantity;
    private int price;
}
