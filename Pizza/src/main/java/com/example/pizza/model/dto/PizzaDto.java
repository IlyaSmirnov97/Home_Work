package com.example.pizza.model.dto;

import com.example.pizza.model.Pizza;
import lombok.Data;

import java.util.UUID;

@Data
public class PizzaDto {
    private String name;
    private int price;
    private UUID id;
    private Pizza.PizzaStatus status;
    private boolean isDeleted = false;
}
