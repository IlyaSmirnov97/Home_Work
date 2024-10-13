package com.example.pizza.service;

import com.example.pizza.model.Customer;
import com.example.pizza.model.Order;
import com.example.pizza.model.dto.OrderDto;
import com.example.pizza.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    // Получение заказа по id
    public OrderDto getOrderId (UUID id){
        Order order = orderRepository.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        return ConvertDtoToOrder(order);
    }

    // Создание заказа
    public void createOrder(Order order){
        orderRepository.save(order);
    }

    // Получение всех заказов
    public List<OrderDto> getAllOrders () {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(this::ConvertDtoToOrder).collect(Collectors.toList());
    }

    // Обновление статуса заказа
    public Optional<OrderDto> updateOrderDtoStatus(UUID id, Order.OrderStatus newStatus) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setStatus(newStatus); // Устанавливаем новый статус
            return Optional.of(ConvertDtoToOrder(order));
        }
        return Optional.empty(); // Если заказ не найден
    }
    private OrderDto ConvertDtoToOrder (Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(orderDto.getId());
        orderDto.setOrder_date(orderDto.getOrder_date());
        orderDto.setCustomer(orderDto.getCustomer());
        orderDto.setStatus(orderDto.getStatus());
        orderDto.setPrice(orderDto.getPrice());
        orderDto.setAddress(orderDto.getAddress());
        return orderDto;
    }
    private Order ConvertOrderDtoToOrder (OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setOrder_date(orderDto.getOrder_date());
        order.setCustomer(orderDto.getCustomer());
        order.setStatus(orderDto.getStatus());
        order.setPrice(orderDto.getPrice());
        order.setAddress(orderDto.getAddress());
        return order;
    }
}
