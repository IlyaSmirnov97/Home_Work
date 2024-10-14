package com.example.pizza.service;


import com.example.pizza.model.CartItem;
import com.example.pizza.model.dto.CartItemDto;
import com.example.pizza.repository.CartItemRepository;
import com.example.pizza.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartItemService {
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;

    // Обновление товара в корзине
    public CartItem updateCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }


    // Создание/Добавление товара в корзины
    public CartItemDto addCartItem(CartItem cartItem, UUID cartId) {
        cartItem.setCart(cartRepository.findById(cartId).get());
        cartItemRepository.save(cartItem);
        return ConvertCartItemToDto(cartItem);
    }

    // Получение товара корзины по id
    public CartItemDto getCartItemById(UUID id) {
        CartItem cartItem = cartItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        return ConvertCartItemToDto(cartItem);
    }

    // Удаление товара из карзины
    public void deleteCartItemById(UUID id) {
        cartItemRepository.deleteById(id);
    }

    // Получение всех товаров
    public List<CartItemDto> getAllCartItems() {
        List<CartItem> cartItems = cartItemRepository.findAll();
        return cartItems.stream().map(this::ConvertCartItemToDto).collect(Collectors.toList());
    }

    private CartItem ConvertDtoToCartItem(CartItemDto cartItemDtoDto) {
        CartItem cartItem = new CartItem();
        cartItem.setId(cartItemDtoDto.getId());
        cartItem.setCart(cartItemDtoDto.getCart());
        cartItem.setQuantity(cartItemDtoDto.getQuantity());
        cartItem.setPizza(cartItemDtoDto.getPizza());
        return cartItem;
    }

    private CartItemDto ConvertCartItemToDto(CartItem cartItem) {
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setId(cartItem.getId());
        cartItemDto.setCart(cartItem.getCart());
        cartItemDto.setQuantity(cartItem.getQuantity());
        cartItemDto.setPizza(cartItem.getPizza());
        return cartItemDto;
    }

}
