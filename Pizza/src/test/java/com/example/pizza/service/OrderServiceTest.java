package com.example.pizza.service;

import com.example.pizza.model.Order;
import com.example.pizza.model.dto.OrderDto;
import com.example.pizza.repository.OrderRepository;
import com.example.pizza.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    private Order order;

    @BeforeEach
    public void setUp() {
        order = new Order();
        order.setId(UUID.randomUUID());
        order.setPrice(100);
        order.setOrder_date(new Timestamp(System.currentTimeMillis()));
        order.setStatus(Order.OrderStatus.NEW); // Начальный статус
    }

    @Test
    public void testGetOrderById() {
        when(orderRepository.findById(order.getId())).thenReturn(Optional.of(order));

        OrderDto orderDto = orderService.getOrderId(order.getId());

        assertNotNull(orderDto);
        assertEquals(order.getId(), orderDto.getId());
    }

    @Test
    public void testCreateOrder() {
        orderService.createOrder(order);

        verify(orderRepository, times(1)).save(order);
    }

    @Test
    public void testGetAllOrders() {
        when(orderRepository.findAll()).thenReturn(List.of(order));

        List<OrderDto> orderDtos = orderService.getAllOrders();

        assertEquals(1, orderDtos.size());
        assertEquals(order.getId(), orderDtos.get(0).getId());
    }

    @Test
    public void testUpdateOrderStatus() {
        when(orderRepository.findById(order.getId())).thenReturn(Optional.of(order));

        Order.OrderStatus newStatus = Order.OrderStatus.COMPLETED; // Используем существующий статус
        orderService.updateOrderDtoStatus(order.getId(), newStatus);

        assertEquals(newStatus, order.getStatus());
    }

    @Test
    public void testUpdateOrderStatus_NotFound() {
        UUID nonExistentId = UUID.randomUUID();
        when(orderRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        Optional<OrderDto> updatedOrderDto = orderService.updateOrderDtoStatus(nonExistentId, Order.OrderStatus.IN_PROGRESS);

        assertTrue(updatedOrderDto.isEmpty());
    }
}
