package com.example.pizza.controller;


import com.example.pizza.model.OrderItem;
import com.example.pizza.model.dto.OrderItemDto;
import com.example.pizza.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order-items")
public class OrderItemController {
    private final OrderItemService orderItemService;

    // Получение всех элементов заказа
    @GetMapping
    public List<OrderItemDto> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    // Получение элемента заказа по ID
    @GetMapping("/{id}")
    public OrderItemDto getOrderItemById(@PathVariable UUID id) {
        return orderItemService.getOrderItemById(id);
    }

    // Создание нового элемента заказа
    @PostMapping
    public ResponseEntity<OrderItemDto> createOrderItem(@RequestBody OrderItem orderItem, UUID orderId) {
        OrderItemDto orderItemDto = orderItemService.createOrderItem(orderItem,orderId);
        return ResponseEntity.ok(orderItemDto);

    }

    // Удаление элемента заказа
    @DeleteMapping("/{id}")
    public void deleteOrderItem(@PathVariable UUID id) {
        orderItemService.deleteOrderItem(id);
    }

    // Обновление статуса элемента заказа
    @PatchMapping("/{id}/status")
    public OrderItemDto updateOrderItemStatus(@PathVariable UUID id, @RequestBody OrderItem.OrderItemStatus newStatus) {
        return orderItemService.updateOrderItemStatus(id, newStatus)
                .orElse(null); // Возвращаем обновленный элемент или null, если не найден
    }
}
