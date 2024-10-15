package com.example.pizza.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Data
@Table(name = "address")
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NonNull
    private String street;

    @NonNull
    private String city;

    @NonNull
    private String state;

    @NonNull
    private String postalCode;

}
