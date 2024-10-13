package com.example.pizza.service;

import com.example.pizza.model.Cart;
import com.example.pizza.model.CartItem;
import com.example.pizza.model.Pizza;
import com.example.pizza.model.dto.CartItemDto;
import com.example.pizza.repository.CartItemRepository;
import com.example.pizza.repository.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CartItemServiceTest {

    @InjectMocks
    private CartItemService cartItemService;

    @Mock
    private CartItemRepository cartItemRepository;

    @Mock
    private CartRepository cartRepository;

    private CartItemDto cartItemDto;
    private CartItem cartItem;
    private Cart cart;
    private Pizza pizza;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        UUID cartId = UUID.randomUUID();
        UUID pizzaId = UUID.randomUUID();

        cart = new Cart();
        cart.setId(cartId);

        pizza = new Pizza();
        pizza.setId(pizzaId);

        cartItemDto = new CartItemDto();
        cartItemDto.setId(UUID.randomUUID());
        cartItemDto.setCart(cart);
        cartItemDto.setQuantity(2);
        cartItemDto.setPizza(pizza);

        cartItem = new CartItem();
        cartItem.setId(cartItemDto.getId());
        cartItem.setCart(cart);
        cartItem.setQuantity(cartItemDto.getQuantity());
        cartItem.setPizza(pizza);
    }

    @Test
    void addCartItem() {
        UUID cartId = cart.getId();
        when(cartRepository.findById(cartId)).thenReturn(Optional.of(cart));
        when(cartItemRepository.save(any(CartItem.class))).thenReturn(cartItem);

        CartItemDto createdCartItemDto = cartItemService.addCartItem(cartItem, cartId);

        assertNotNull(createdCartItemDto);
        assertEquals(cartItemDto.getId(), createdCartItemDto.getId());
        assertEquals(cartItemDto.getQuantity(), createdCartItemDto.getQuantity());
        verify(cartRepository, times(1)).findById(cartId);
        verify(cartItemRepository, times(1)).save(any(CartItem.class));
    }

    @Test
    void getCartItemById() {
        when(cartItemRepository.findById(any(UUID.class))).thenReturn(Optional.of(cartItem));

        CartItemDto foundCartItemDto = cartItemService.getCartItemById(cartItemDto.getId());

        assertNotNull(foundCartItemDto);
        assertEquals(cartItemDto.getId(), foundCartItemDto.getId());
        verify(cartItemRepository, times(1)).findById(cartItemDto.getId());
    }

    @Test
    void getAllCartItems() {
        when(cartItemRepository.findAll()).thenReturn(Collections.singletonList(cartItem));

        List<CartItemDto> cartItemDtoList = cartItemService.getAllCartItems();

        assertNotNull(cartItemDtoList);
        assertEquals(1, cartItemDtoList.size());
        assertEquals(cartItemDto.getId(), cartItemDtoList.get(0).getId());
        verify(cartItemRepository, times(1)).findAll();
    }

    @Test
    void updateCartItem() {
        when(cartItemRepository.save(any(CartItem.class))).thenReturn(cartItem);

        CartItem updatedCartItem = cartItemService.updateCartItem(cartItem);

        assertNotNull(updatedCartItem);
        assertEquals(cartItem.getId(), updatedCartItem.getId());
        verify(cartItemRepository, times(1)).save(any(CartItem.class));
    }

    @Test
    void deleteCartItemById() {
        UUID cartItemId = cartItemDto.getId();
        doNothing().when(cartItemRepository).deleteById(cartItemId);

        cartItemService.deleteCartItemById(cartItemId);

        verify(cartItemRepository, times(1)).deleteById(cartItemId);
    }

    @Test
    void getCartItemByIdNotFound() {
        when(cartItemRepository.findById(any(UUID.class))).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            cartItemService.getCartItemById(cartItemDto.getId());
        });

        assertEquals("Not found", thrown.getMessage());
    }
}
