package com.example.pizza.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CustomerDto {
    private String firstName;
    private String lastName;
    private String phone;
    private UUID id;
}
