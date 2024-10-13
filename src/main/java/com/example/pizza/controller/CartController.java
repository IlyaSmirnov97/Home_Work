package com.example.pizza.controller;

import com.example.pizza.model.Cart;
import com.example.pizza.model.dto.CartDto;
import com.example.pizza.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;



    // Создает новую корзину
    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        Cart createdCart = cartService.createCart(cart); // Сохранение корзины
        return ResponseEntity.ok(createdCart); // Возврат созданной корзины
    }

    // Получаем корзину по id
    @GetMapping("/{id}")
    public ResponseEntity<CartDto> getCartById(@PathVariable UUID id) {
        CartDto cart = cartService.getCartById(id);
        return ResponseEntity.ok(cart);
    }

    // Получает список всех корзин
    @GetMapping
    public ResponseEntity<List<CartDto>> getAllCarts() {
        List<CartDto> carts = cartService.getAllCarts(); // Получение всех корзин
        return ResponseEntity.ok(carts); // Возврат списка корзин
    }

    // Обновляет корзину по идентификатору
    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable UUID id, @RequestBody Cart cart) {
        cart.setId(id);
        Cart updatedCart = cartService.updateCart(cart); // Обновление корзины
        return ResponseEntity.ok(updatedCart); // Возврат обновленной корзины
    }

    // Удаляет корзину по идентификатору
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable UUID id) {
        cartService.deleteCart(id); // Удаление корзины
        return ResponseEntity.noContent().build(); // Возврат 204 No Content
    }

}
