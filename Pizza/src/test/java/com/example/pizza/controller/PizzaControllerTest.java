package com.example.pizza.controller;

import com.example.pizza.model.Pizza;
import com.example.pizza.service.PizzaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaControllerTest {

    @Mock
    private PizzaService pizzaService;

    @InjectMocks
    private PizzaController pizzaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createPizzaById() {
        // Создаем объект Pizza для теста
        Pizza pizza = new Pizza();
        pizza.setName("Margarita");
        pizza.setPrice(500);

        // Вызов контроллера
        ResponseEntity<String> response = pizzaController.createPizzaById(pizza);

        // Проверка результата
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Пицца успешно добавлена", response.getBody());

        // Проверка, что метод сервиса был вызван
        verify(pizzaService).createPizza(any(Pizza.class));
    }
}
