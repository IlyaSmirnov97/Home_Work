package com.example.pizza.controller;

import com.example.pizza.model.OrderItem;
import com.example.pizza.model.dto.OrderItemDto;
import com.example.pizza.service.OrderItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class OrderItemControllerTest {

    @InjectMocks
    private OrderItemController orderItemController;

    @Mock
    private OrderItemService orderItemService;

    private OrderItem orderItem;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        orderItem = new OrderItem();
        orderItem.setId(UUID.randomUUID());
        orderItem.setQuantity(2);
        orderItem.setStatus(OrderItem.OrderItemStatus.PENDING); // Используем статус из вашей модели
    }

    @Test
    public void testGetAllOrderItems() {
        when(orderItemService.getAllOrderItems()).thenReturn(Collections.singletonList(new OrderItemDto()));

        List<OrderItemDto> result = orderItemController.getAllOrderItems();

        assertEquals(1, result.size());
        verify(orderItemService, times(1)).getAllOrderItems();
    }

    @Test
    public void testGetOrderItemById() {
        UUID id = orderItem.getId();
        when(orderItemService.getOrderItemById(id)).thenReturn(new OrderItemDto());

        OrderItemDto result = orderItemController.getOrderItemById(id);

        assertEquals(new OrderItemDto(), result);
        verify(orderItemService, times(1)).getOrderItemById(id);
    }

    @Test
    public void testCreateOrderItem() {
        UUID orderId = UUID.randomUUID(); // Замените на реальный ID заказа
        OrderItemDto createdOrderItemDto = new OrderItemDto(); // Создайте необходимый DTO
        when(orderItemService.createOrderItem(any(OrderItem.class), any(UUID.class))).thenReturn(createdOrderItemDto);

        ResponseEntity<OrderItemDto> response = orderItemController.createOrderItem(orderItem, orderId);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(createdOrderItemDto, response.getBody());
        verify(orderItemService, times(1)).createOrderItem(any(OrderItem.class), any(UUID.class));
    }

    @Test
    public void testDeleteOrderItem() {
        UUID id = orderItem.getId();
        doNothing().when(orderItemService).deleteOrderItem(id);

        orderItemController.deleteOrderItem(id);

        verify(orderItemService, times(1)).deleteOrderItem(id);
    }

    @Test
    public void testUpdateOrderItemStatus() {
        UUID id = orderItem.getId();
        OrderItem.OrderItemStatus newStatus = OrderItem.OrderItemStatus.PREPARED;
        OrderItemDto updatedOrderItemDto = new OrderItemDto(); // Создайте необходимый DTO
        when(orderItemService.updateOrderItemStatus(id, newStatus)).thenReturn(java.util.Optional.of(updatedOrderItemDto));

        OrderItemDto result = orderItemController.updateOrderItemStatus(id, newStatus);

        assertEquals(updatedOrderItemDto, result);
        verify(orderItemService, times(1)).updateOrderItemStatus(id, newStatus);
    }
}
