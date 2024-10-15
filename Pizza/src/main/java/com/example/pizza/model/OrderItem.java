package com.example.pizza.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Table(name = "order_items")
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

    private int quantity; // Количество пиццы в заказе

    @Enumerated(EnumType.STRING)
    private OrderItemStatus status; // Статус элемента заказа

    public enum OrderItemStatus {
        PENDING,          // В ожидании
        PREPARED,         // Приготовлено
        SERVED,           // Выдано
        CANCELLED         // Отменено
    }
}
