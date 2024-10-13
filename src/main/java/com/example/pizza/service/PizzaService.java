package com.example.pizza.service;

import com.example.pizza.model.Pizza;
import com.example.pizza.model.dto.PizzaDto;
import com.example.pizza.repository.PizzaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    //Получени пиццы по id
    public PizzaDto getPizzaById(UUID id) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        return ConvertDtoToPizza(pizza);
    }

    // Создание пиццы
    public void createPizza(Pizza pizza) {
        pizzaRepository.save(pizza);
    }

    //Удаление пиццы
    public void deletePizza(UUID id) {

        Pizza pizza = pizzaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        pizza.setDeleted(true); // Устанавливаем флаг удаления
        pizzaRepository.save(pizza);
    }

    // Обновление пицыы
    public void updatePizzaById(String name, int price, UUID id) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        pizza.setName(name);
        pizza.setPrice(price);
        pizzaRepository.save(pizza);
    }

    // Получение всех пицц
    public List<PizzaDto> getAllPizza() {
        List<Pizza> pizzas = pizzaRepository.findAll();
        return pizzas.stream().map(this::ConvertDtoToPizza).collect(Collectors.toList());
    }

    // Обновление статуса пиццы
    public Optional<PizzaDto> updatePizzaStatus(UUID id, Pizza.PizzaStatus newStatus) {
        Optional<Pizza> optionalPizza = pizzaRepository.findById(id);
        if (optionalPizza.isPresent()) {
            Pizza pizza = optionalPizza.get();
            pizza.setStatus(newStatus); // Устанавливаем новый статус
            return Optional.of(ConvertDtoToPizza(pizza));
        }
        return Optional.empty(); // Если пицца не найдена
    }

    public List<Pizza> AllByIsDeletedFalse() {
        return pizzaRepository.findAllByIsDeletedFalse(); // Возвращает только не удаленные пиццы
    }

    public List<Pizza> getAllDeletedPizzas() {
        return pizzaRepository.findAllByIsDeletedTrue(); // Возвращает только удаленные пиццы
    }


    private PizzaDto ConvertDtoToPizza(Pizza pizza) {
        PizzaDto pizzaDto = new PizzaDto();
        pizzaDto.setId(pizza.getId());
        pizzaDto.setName(pizza.getName());
        pizzaDto.setPrice(pizza.getPrice());
        pizzaDto.setStatus(pizza.getStatus());
        pizzaDto.setDeleted(pizza.isDeleted());
        return pizzaDto;
    }

}
