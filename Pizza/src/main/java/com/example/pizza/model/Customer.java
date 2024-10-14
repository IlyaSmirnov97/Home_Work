package com.example.pizza.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Data
@Table(name = "customer")
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Customer {
    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String phone;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
}

