package com.example.pizza.controller;

import com.example.pizza.model.Cart;
import com.example.pizza.model.dto.CartDto;
import com.example.pizza.service.CartService;
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
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CartControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CartService cartService;

    @InjectMocks
    private CartController cartController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(cartController).build();
    }

    @Test
    public void testCreateCart() throws Exception {
        Cart cart = new Cart();
        cart.setId(UUID.randomUUID());

        when(cartService.createCart(any(Cart.class))).thenReturn(cart);

        mockMvc.perform(post("/api/cart")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"" + cart.getId() + "\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(cart.getId().toString()));

        verify(cartService, times(1)).createCart(any(Cart.class));
    }

    @Test
    public void testGetCartById() throws Exception {
        UUID id = UUID.randomUUID();
        CartDto cartDto = new CartDto();
        cartDto.setId(id);

        when(cartService.getCartById(eq(id))).thenReturn(cartDto);

        mockMvc.perform(get("/api/cart/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id.toString()));

        verify(cartService, times(1)).getCartById(eq(id));
    }

    @Test
    public void testGetAllCarts() throws Exception {
        List<CartDto> carts = new ArrayList<>();
        CartDto cart1 = new CartDto();
        cart1.setId(UUID.randomUUID());
        carts.add(cart1);

        CartDto cart2 = new CartDto();
        cart2.setId(UUID.randomUUID());
        carts.add(cart2);

        when(cartService.getAllCarts()).thenReturn(carts);

        mockMvc.perform(get("/api/cart"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(cart1.getId().toString()))
                .andExpect(jsonPath("$[1].id").value(cart2.getId().toString()));

        verify(cartService, times(1)).getAllCarts();
    }

    @Test
    public void testUpdateCart() throws Exception {
        UUID id = UUID.randomUUID();
        Cart cart = new Cart();
        cart.setId(id);

        when(cartService.updateCart(any(Cart.class))).thenReturn(cart);

        mockMvc.perform(put("/api/cart/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"" + cart.getId() + "\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(cart.getId().toString()));

        verify(cartService, times(1)).updateCart(any(Cart.class));
    }

    @Test
    public void testDeleteCart() throws Exception {
        UUID id = UUID.randomUUID();

        doNothing().when(cartService).deleteCart(eq(id));

        mockMvc.perform(delete("/api/cart/{id}", id))
                .andExpect(status().isNoContent());

        verify(cartService, times(1)).deleteCart(eq(id));
    }
}
