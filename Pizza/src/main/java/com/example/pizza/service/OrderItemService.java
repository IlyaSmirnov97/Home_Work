package com.example.pizza.service;


import com.example.pizza.model.OrderItem;
import com.example.pizza.model.dto.OrderItemDto;
import com.example.pizza.repository.OrderItemRepository;
import com.example.pizza.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;

    // Добавление товара в заказ
    public OrderItemDto createOrderItem (OrderItem orderItem, UUID orderId) {
        orderItem.setOrder(orderRepository.findById(orderId).get());
        orderItemRepository.save(orderItem);
        return ConvertOrderItemToDto(orderItem);
    }

    // Получение всех элементов заказа
    public List<OrderItemDto> getAllOrderItems() {
        List<OrderItem> orderItems = orderItemRepository.findAll();
        return orderItems.stream().map(this::ConvertOrderItemToDto).collect(Collectors.toList());
    }

    // Получение элемента заказа по ID
    public OrderItemDto getOrderItemById(UUID id) {
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        return ConvertOrderItemToDto(orderItem);
    }


    // Удаление элемента заказа
    public void deleteOrderItem(UUID id) {
        orderItemRepository.deleteById(id);
    }


    // Обновление статуса
    public Optional<OrderItemDto> updateOrderItemStatus(UUID id, OrderItem.OrderItemStatus newStatus) {
        Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(id);
        if (optionalOrderItem.isPresent()) {
            OrderItem orderItem = optionalOrderItem.get();
            orderItem.setStatus(newStatus); // Устанавливаем новый статус
            orderItemRepository.save(orderItem); // Сохраняем изменения
            return Optional.of(ConvertOrderItemToDto(orderItem));
        }
        return Optional.empty(); // Если элемент не найден
    }

    private OrderItem ConvertDtoToOrderItem(OrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemDto.getId());
        orderItem.setOrder(orderItemDto.getOrder());
        orderItem.setQuantity(orderItemDto.getQuantity());
        orderItem.setPizza(orderItemDto.getPizza());
        orderItem.setStatus(orderItemDto.getStatus());
        return orderItem;
    }

    private OrderItemDto ConvertOrderItemToDto(OrderItem orderItem) {
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setId(orderItem.getId());
        orderItemDto.setOrder(orderItem.getOrder());
        orderItemDto.setQuantity(orderItem.getQuantity());
        orderItemDto.setPizza(orderItem.getPizza());
        orderItemDto.setStatus(orderItem.getStatus());
        return orderItemDto;
    }
}
