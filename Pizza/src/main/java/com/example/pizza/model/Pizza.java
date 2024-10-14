package com.example.pizza.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Table(name = "pizza")
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Pizza {
    private String name;
    private int price;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
 private UUID id;
    @Enumerated(EnumType.STRING)
    private PizzaStatus status;

    public enum PizzaStatus {
        AVAILABLE,       // В продаже
        UNAVAILABLE      // Не в продаже
    }

    private boolean isDeleted = false;

}
