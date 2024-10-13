package com.example.pizza.controller;


import com.example.pizza.model.Order;
import com.example.pizza.model.dto.OrderDto;
import com.example.pizza.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/order")

public class OrderController {
    private final OrderService orderService;

    // Получение заказа по id
    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable UUID id) {
        OrderDto order = orderService.getOrderId(id);
        return ResponseEntity.ok().body(order);
    }

    // Создание заказа
    @PostMapping()
    public ResponseEntity<String> createOrderById(@RequestBody Order order) {
        orderService.createOrder(order);
        return ResponseEntity.ok("Заказ успешно офрмлен");
    }

    // Получение всех заказов
    @GetMapping()
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> order = orderService.getAllOrders();
        return ResponseEntity.ok().body(order);
    }

    // Обновление статуса заказа
    @PatchMapping("/{id}/status")
    public OrderDto updateOrderDtoStatus(@PathVariable UUID id, @RequestBody Order.OrderStatus newStatus) {
        return orderService.updateOrderDtoStatus(id, newStatus)
                .orElse(null); // Возвращаем обновленный заказ или null, если не найден
    }
}
