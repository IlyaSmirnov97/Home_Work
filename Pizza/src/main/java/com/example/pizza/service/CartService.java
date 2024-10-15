package com.example.pizza.service;


import com.example.pizza.model.Cart;
import com.example.pizza.model.dto.CartDto;
import com.example.pizza.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartService {


    private final CartRepository cartRepository;

    // Создание корзины
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    // Получение корзины по id
    public CartDto getCartById(UUID id) {
        Cart cart = cartRepository.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        return ConvertCartToDto(cart);
    }

    // Получение всех корзин
    public List<CartDto> getAllCarts() {
       List<Cart> carts = cartRepository.findAll();
       return carts.stream().map(this::ConvertCartToDto).collect(Collectors.toList());

    }

    // Обновление карзины
    public Cart updateCart(Cart cart) {
        return cartRepository.save(cart);
    }

    // Удаление козины
    public void deleteCart(UUID id) {
        cartRepository.deleteById(id);
    }

    private Cart ConvertDtoToCart(CartDto cartDto) {
        Cart cart = new Cart();
        cart.setId(cartDto.getId());
        cart.setCustomer(cartDto.getCustomer());
        cart.setActive(cartDto.isActive());
        return cart;
    }

    private CartDto ConvertCartToDto(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setId(cart.getId());
        cartDto.setCustomer(cart.getCustomer());
        cartDto.setActive(cart.isActive());
        return cartDto;
    }
}
