package com.example.pizza.service;

import com.example.pizza.model.Order;
import com.example.pizza.model.OrderItem;
import com.example.pizza.model.dto.OrderItemDto;
import com.example.pizza.repository.OrderItemRepository;
import com.example.pizza.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderItemServiceTest  {

    @Mock
    private OrderItemRepository orderItemRepository;

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderItemService orderItemService;

    private OrderItem orderItem;

    @BeforeEach
    public void setUp() {
        orderItem = new OrderItem();
        orderItem.setId(UUID.randomUUID());
        orderItem.setQuantity(1);
        orderItem.setStatus(OrderItem.OrderItemStatus.PENDING); // Начальный статус
    }

    @Test
    public void testCreateOrderItem() {
        when(orderRepository.findById(any(UUID.class))).thenReturn(Optional.of(new Order()));
        when(orderItemRepository.save(any(OrderItem.class))).thenReturn(orderItem);

        OrderItemDto createdOrderItemDto = orderItemService.createOrderItem(orderItem, UUID.randomUUID());

        assertNotNull(createdOrderItemDto);
        assertEquals(orderItem.getId(), createdOrderItemDto.getId());
        assertEquals(orderItem.getQuantity(), createdOrderItemDto.getQuantity());
        assertEquals(OrderItem.OrderItemStatus.PENDING, createdOrderItemDto.getStatus()); // Проверяем начальный статус
    }

    @Test
    public void testGetOrderItemById() {
        when(orderItemRepository.findById(orderItem.getId())).thenReturn(Optional.of(orderItem));

        OrderItemDto foundOrderItemDto = orderItemService.getOrderItemById(orderItem.getId());

        assertNotNull(foundOrderItemDto);
        assertEquals(orderItem.getId(), foundOrderItemDto.getId());
        assertEquals(orderItem.getQuantity(), foundOrderItemDto.getQuantity());
        assertEquals(orderItem.getStatus(), foundOrderItemDto.getStatus()); // Проверяем статус
    }

    @Test
    public void testUpdateOrderItemStatus() {
        when(orderItemRepository.findById(orderItem.getId())).thenReturn(Optional.of(orderItem));

        // Обновляем статус
        OrderItem.OrderItemStatus newStatus = OrderItem.OrderItemStatus.PREPARED; // Можно выбрать любой статус
        Optional<OrderItemDto> updatedOrderItemDto = orderItemService.updateOrderItemStatus(orderItem.getId(), newStatus);

        assertTrue(updatedOrderItemDto.isPresent(), "Order item DTO should be present after update");
        assertEquals(newStatus, updatedOrderItemDto.get().getStatus(), "Order item status should be updated");
    }

    @Test
    public void testDeleteOrderItem() {
        doNothing().when(orderItemRepository).deleteById(orderItem.getId());

        orderItemService.deleteOrderItem(orderItem.getId());

        verify(orderItemRepository, times(1)).deleteById(orderItem.getId());
    }

    @Test
    public void testGetAllOrderItems() {
        when(orderItemRepository.findAll()).thenReturn(List.of(orderItem));

        List<OrderItemDto> orderItemDtos = orderItemService.getAllOrderItems();

        assertNotNull(orderItemDtos);
        assertEquals(1, orderItemDtos.size());
        assertEquals(orderItem.getId(), orderItemDtos.get(0).getId());
    }
}
