package com.example.pizza.controller;

import com.example.pizza.model.Pizza;
import com.example.pizza.model.dto.PizzaDto;
import com.example.pizza.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/pizza")
public class PizzaController {
    private final PizzaService pizzaService;

    // Получение пиццы по id
    @GetMapping("/{id}")
    public ResponseEntity<PizzaDto> getPizzaById(@PathVariable UUID id){
        PizzaDto pizza = pizzaService.getPizzaById(id);
        return ResponseEntity.ok().body(pizza);
    }
    // Создание пиццы
    @PostMapping()
    public ResponseEntity<String> createPizzaById(@RequestBody Pizza pizza){
        pizzaService.createPizza(pizza);
        return ResponseEntity.ok("Пицца успешно добавлена");
    }
    // Удалить пиццу (мягкое удаление)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable UUID id) {
        pizzaService.deletePizza(id);
        return ResponseEntity.noContent().build();
    }
    // Обновление пиццы
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePizzaById(@PathVariable UUID id, @RequestBody Pizza pizza){
        pizzaService.updatePizzaById(pizza.getName(), pizza.getPrice(), id);
        return ResponseEntity.ok("Пицца обновленна");
    }
    // Получение всех пицц
    @GetMapping
    public ResponseEntity<List<PizzaDto>> getAllPizza(){
        List<PizzaDto> pizza = pizzaService.getAllPizza();
        return ResponseEntity.ok(pizza);
    }
    // Обновление статуса пиццы
    @PatchMapping("/{id}/status")
    public PizzaDto updatePizzaStatus(@PathVariable UUID id, @RequestBody Pizza.PizzaStatus newStatus) {
        return pizzaService.updatePizzaStatus(id, newStatus)
                .orElse(null); // Возвращаем обновленную пиццу или null, если не найдена
    }
}
