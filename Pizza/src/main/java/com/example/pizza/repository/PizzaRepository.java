package com.example.pizza.repository;


import com.example.pizza.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PizzaRepository extends JpaRepository<Pizza, UUID> {
    List<Pizza> findAllByIsDeletedFalse(); // Получить не удаленные пиццы
    List<Pizza> findAllByIsDeletedTrue(); // Получить удаленные пиццы
}
