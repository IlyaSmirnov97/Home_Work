package com.example.pizza.controller;

import com.example.pizza.model.Address;
import com.example.pizza.model.dto.AddressDto;
import com.example.pizza.service.AddressService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AddressControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AddressService addressService;

    @InjectMocks
    private AddressController addressController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(addressController).build();
    }

    @Test
    public void testCreateAddress() throws Exception {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(UUID.randomUUID());
        addressDto.setStreet("123 Main St");

        when(addressService.createAddress(any(AddressDto.class))).thenReturn(addressDto);

        mockMvc.perform(post("/api/addresses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"street\": \"123 Main St\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.street").value("123 Main St"));

        verify(addressService, times(1)).createAddress(any(AddressDto.class));
    }

    @Test
    public void testGetAddress() throws Exception {
        UUID id = UUID.randomUUID();
        AddressDto addressDto = new AddressDto();
        addressDto.setId(id);
        addressDto.setStreet("123 Main St");

        when(addressService.getAddressId(eq(id))).thenReturn(addressDto);

        mockMvc.perform(get("/api/addresses/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id.toString()))
                .andExpect(jsonPath("$.street").value("123 Main St"));

        verify(addressService, times(1)).getAddressId(eq(id));
    }

    @Test
    public void testGetAllAddresses() throws Exception {
        List<AddressDto> addresses = new ArrayList<>();
        AddressDto address1 = new AddressDto();
        address1.setId(UUID.randomUUID());
        address1.setStreet("123 Main St");
        addresses.add(address1);

        AddressDto address2 = new AddressDto();
        address2.setId(UUID.randomUUID());
        address2.setStreet("456 Elm St");
        addresses.add(address2);

        when(addressService.getAllAddresses()).thenReturn(addresses);

        mockMvc.perform(get("/api/addresses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].street").value("123 Main St"))
                .andExpect(jsonPath("$[1].street").value("456 Elm St"));

        verify(addressService, times(1)).getAllAddresses();
    }

    @Test
    public void testUpdateAddress() throws Exception {
        UUID id = UUID.randomUUID();
        Address address = new Address();
        address.setId(id);
        address.setStreet("123 Main St");

        when(addressService.updateAddress(any(Address.class))).thenReturn(address);

        mockMvc.perform(put("/api/addresses/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"street\": \"123 Main St\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.street").value("123 Main St"));

        verify(addressService, times(1)).updateAddress(any(Address.class));
    }

    @Test
    public void testDeleteAddress() throws Exception {
        UUID id = UUID.randomUUID();

        doNothing().when(addressService).deleteAddress(eq(id));

        mockMvc.perform(delete("/api/addresses/{id}", id))
                .andExpect(status().isNoContent());

        verify(addressService, times(1)).deleteAddress(eq(id));
    }
}
