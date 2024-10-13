package com.example.pizza.controller;

import com.example.pizza.model.Order;
import com.example.pizza.model.dto.OrderDto;
import com.example.pizza.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class OrderControllerTest {

    private MockMvc mockMvc;

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    void testGetOrderById() throws Exception {
        UUID orderId = UUID.randomUUID();
        OrderDto orderDto = new OrderDto();
        orderDto.setId(orderId);

        when(orderService.getOrderId(orderId)).thenReturn(orderDto);

        mockMvc.perform(get("/api/order/{id}", orderId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(orderId.toString()));

        verify(orderService, times(1)).getOrderId(orderId);
    }

    @Test
    void testCreateOrder() throws Exception {
        Order order = new Order();
        String orderJson = "{ /* JSON представление вашего заказа */ }";

        mockMvc.perform(post("/api/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(orderJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Заказ успешно оформлен"));

        verify(orderService, times(1)).createOrder(any(Order.class));
    }

    @Test
    void testGetAllOrders() throws Exception {
        List<OrderDto> orders = new ArrayList<>();
        when(orderService.getAllOrders()).thenReturn(orders);

        mockMvc.perform(get("/api/order"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());

        verify(orderService, times(1)).getAllOrders();
    }

    @Test
    void testUpdateOrderStatus() throws Exception {
        UUID orderId = UUID.randomUUID();
        Order.OrderStatus newStatus = Order.OrderStatus.COMPLETED;
        OrderDto updatedOrderDto = new OrderDto();
        updatedOrderDto.setId(orderId);
        updatedOrderDto.setStatus(newStatus);

        when(orderService.updateOrderDtoStatus(eq(orderId), eq(newStatus)))
                .thenReturn(Optional.of(updatedOrderDto));

        String statusJson = "{ \"newStatus\": \"COMPLETED\" }";

        mockMvc.perform(patch("/api/order/{id}/status", orderId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(statusJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(orderId.toString()))
                .andExpect(jsonPath("$.status").value(newStatus.toString()));

        verify(orderService, times(1)).updateOrderDtoStatus(eq(orderId), eq(newStatus));
    }
}
