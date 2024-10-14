package com.example.pizza.service;

import com.example.pizza.model.Cart;
import com.example.pizza.model.dto.CartDto;
import com.example.pizza.repository.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CartServiceTest {

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private CartService cartService;

    private Cart cart;
    private CartDto cartDto;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cart = new Cart();
        cart.setId(UUID.randomUUID());
        cart.setActive(true);
        // Установите необходимые поля

        cartDto = new CartDto();
        cartDto.setId(cart.getId());
        cartDto.setActive(cart.isActive());
        // Установите необходимые поля
    }

    @Test
    public void testCreateCart() {
        when(cartRepository.save(any(Cart.class))).thenReturn(cart);

        Cart createdCart = cartService.createCart(cart);

        assertNotNull(createdCart);
        assertEquals(cart.getId(), createdCart.getId());
        assertEquals(cart.isActive(), createdCart.isActive());

        verify(cartRepository, times(1)).save(cart);
    }

    @Test
    public void testGetCartById() {
        when(cartRepository.findById(cart.getId())).thenReturn(Optional.of(cart));

        CartDto foundCartDto = cartService.getCartById(cart.getId());

        assertNotNull(foundCartDto);
        assertEquals(cart.getId(), foundCartDto.getId());
        assertEquals(cart.isActive(), foundCartDto.isActive());

        verify(cartRepository, times(1)).findById(cart.getId());
    }

    @Test
    public void testGetAllCarts() {
        when(cartRepository.findAll()).thenReturn(Arrays.asList(cart));

        List<CartDto> cartDtos = cartService.getAllCarts();

        assertNotNull(cartDtos);
        assertEquals(1, cartDtos.size());
        assertEquals(cart.getId(), cartDtos.get(0).getId());

        verify(cartRepository, times(1)).findAll();
    }

    @Test
    public void testUpdateCart() {
        when(cartRepository.save(any(Cart.class))).thenReturn(cart);

        Cart updatedCart = cartService.updateCart(cart);

        assertNotNull(updatedCart);
        assertEquals(cart.getId(), updatedCart.getId());
        assertEquals(cart.isActive(), updatedCart.isActive());

        verify(cartRepository, times(1)).save(cart);
    }

    @Test
    public void testDeleteCart() {
        UUID cartId = cart.getId();
        doNothing().when(cartRepository).deleteById(cartId);

        cartService.deleteCart(cartId);

        verify(cartRepository, times(1)).deleteById(cartId);
    }
}
