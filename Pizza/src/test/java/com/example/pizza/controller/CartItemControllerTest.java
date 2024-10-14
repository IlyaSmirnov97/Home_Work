package com.example.pizza.controller;

import com.example.pizza.model.CartItem;
import com.example.pizza.model.dto.CartItemDto;
import com.example.pizza.service.CartItemService;
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

public class CartItemControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CartItemService cartItemService;

    @Mock
    private CartService cartService;

    @InjectMocks
    private CartItemController cartItemController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(cartItemController).build();
    }

    @Test
    public void testAddCartItem() throws Exception {
        UUID id = UUID.randomUUID();
        CartItem cartItem = new CartItem();
        CartItemDto cartItemDto = new CartItemDto();

        when(cartItemService.addCartItem(any(CartItem.class), eq(id))).thenReturn(cartItemDto);

        mockMvc.perform(post("/api/cart/item")
                        .param("id", id.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"" + cartItem.getId() + "\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(cartItemDto.getId().toString()));

        verify(cartItemService, times(1)).addCartItem(any(CartItem.class), eq(id));
    }

    @Test
    public void testDeleteCartItem() throws Exception {
        UUID id = UUID.randomUUID();
        CartItem cartItem = new CartItem();

        doNothing().when(cartService).deleteCart(eq(id));

        mockMvc.perform(delete("/api/cart/item")
                        .param("id", id.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"" + cartItem.getId() + "\"}"))
                .andExpect(status().isNoContent());

        verify(cartService, times(1)).deleteCart(eq(id));
    }

    @Test
    public void testGetAllCartItems() throws Exception {
        List<CartItemDto> cartItems = new ArrayList<>();
        CartItemDto cartItem1 = new CartItemDto();
        cartItem1.setId(UUID.randomUUID());
        cartItems.add(cartItem1);

        CartItemDto cartItem2 = new CartItemDto();
        cartItem2.setId(UUID.randomUUID());
        cartItems.add(cartItem2);

        when(cartItemService.getAllCartItems()).thenReturn(cartItems);

        mockMvc.perform(get("/api/cart/item"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(cartItem1.getId().toString()))
                .andExpect(jsonPath("$[1].id").value(cartItem2.getId().toString()));

        verify(cartItemService, times(1)).getAllCartItems();
    }

    @Test
    public void testGetCartById() throws Exception {
        UUID id = UUID.randomUUID();
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setId(id);

        when(cartItemService.getCartItemById(eq(id))).thenReturn(cartItemDto);

        mockMvc.perform(put("/api/cart/item/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id.toString()));

        verify(cartItemService, times(1)).getCartItemById(eq(id));
    }
}
