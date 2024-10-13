package com.example.pizza.service;

import com.example.pizza.model.Pizza;
import com.example.pizza.model.dto.PizzaDto;
import com.example.pizza.repository.PizzaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PizzaServiceTest {

    @Mock
    private PizzaRepository pizzaRepository;

    @InjectMocks
    private PizzaService pizzaService;

    private Pizza pizza;
    private PizzaDto pizzaDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Инициализация объекта Pizza
        pizza = new Pizza("Margarita", 500, UUID.randomUUID(), Pizza.PizzaStatus.AVAILABLE, false);

        // Инициализация PizzaDto
        pizzaDto = new PizzaDto();
        pizzaDto.setId(pizza.getId());
        pizzaDto.setName(pizza.getName());
        pizzaDto.setPrice(pizza.getPrice());
        pizzaDto.setDeleted(pizza.isDeleted());
    }

    @Test
    void testCreatePizza() {
        when(pizzaRepository.save(pizza)).thenReturn(pizza);

        pizzaService.createPizza(pizza);

        verify(pizzaRepository, times(1)).save(pizza);
    }

    @Test
    void testGetPizzaById() {
        when(pizzaRepository.findById(pizza.getId())).thenReturn(Optional.of(pizza));

        PizzaDto foundPizzaDto = pizzaService.getPizzaById(pizza.getId());

        assertEquals(pizza.getId(), foundPizzaDto.getId());
        assertEquals(pizza.getName(), foundPizzaDto.getName());
        assertEquals(pizza.getPrice(), foundPizzaDto.getPrice());
        assertFalse(foundPizzaDto.isDeleted());
    }

    @Test
    void testDeletePizza() {
        when(pizzaRepository.findById(pizza.getId())).thenReturn(Optional.of(pizza));

        pizzaService.deletePizza(pizza.getId());

        verify(pizzaRepository, times(1)).save(pizza);
        assertTrue(pizza.isDeleted()); // Проверяем, что флаг удаления установлен
    }

    @Test
    void testUpdatePizzaById() {
        String newName = "Pepperoni";
        int newPrice = 600;

        when(pizzaRepository.findById(pizza.getId())).thenReturn(Optional.of(pizza));

        pizzaService.updatePizzaById(newName, newPrice, pizza.getId());

        assertEquals(newName, pizza.getName());
        assertEquals(newPrice, pizza.getPrice());
        verify(pizzaRepository, times(1)).save(pizza);
    }

    @Test
    void testUpdatePizzaStatus() {
        Pizza.PizzaStatus newStatus = Pizza.PizzaStatus.UNAVAILABLE;

        when(pizzaRepository.findById(pizza.getId())).thenReturn(Optional.of(pizza));

        Optional<PizzaDto> updatedPizzaDto = pizzaService.updatePizzaStatus(pizza.getId(), newStatus);

        assertTrue(updatedPizzaDto.isPresent());
        assertEquals(newStatus, updatedPizzaDto.get().getStatus());
        verify(pizzaRepository, times(1)).save(pizza);
    }
}
