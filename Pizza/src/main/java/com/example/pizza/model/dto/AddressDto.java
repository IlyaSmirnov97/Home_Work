package com.example.pizza.model.dto;


import com.example.pizza.model.Customer;
import lombok.Data;

import java.util.UUID;

@Data
public class AddressDto {
    private UUID id;
    private String street;
    private String city;
    private String state;
    private String postalCode;
}
