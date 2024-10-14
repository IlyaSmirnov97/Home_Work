package com.example.pizza.controller;


import com.example.pizza.model.Cart;
import com.example.pizza.model.CartItem;
import com.example.pizza.model.dto.CartDto;
import com.example.pizza.model.dto.CartItemDto;
import com.example.pizza.service.CartItemService;
import com.example.pizza.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart/item")
public class CartItemController {
    private final CartItemService cartItemService;
    private final CartService cartService;

    // Добавление товара в корзину
    @PostMapping
    public ResponseEntity<CartItemDto> addCartItem (@RequestBody CartItem cartItem, UUID id) {
        CartItemDto cartItemDto = cartItemService.addCartItem(cartItem, id);
        return ResponseEntity.ok(cartItemDto);
    }

    // Удаление товара из корзины
    @DeleteMapping
    public ResponseEntity<CartItem> deleteCartItem (@RequestBody CartItem cartItem, UUID id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }
 // Получение всех товаров из корзины
    @GetMapping
    public ResponseEntity<List<CartItemDto>> getAllCartItems() {
        List<CartItemDto> cartItemList = cartItemService.getAllCartItems();
        return ResponseEntity.ok(cartItemList);
    }

    // Изменения товаров в корзине
    @PutMapping("/{id}")
    public ResponseEntity<CartItemDto> getCartById (@PathVariable UUID id){
        CartItemDto cartItemDto = cartItemService.getCartItemById(id);
        return ResponseEntity.ok(cartItemDto);
    }
}
