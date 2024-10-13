package com.example.pizza.controller;

import com.example.pizza.model.Customer;
import com.example.pizza.model.dto.CustomerDto;
import com.example.pizza.service.CustomerService;
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

public class CustomerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void testGetCustomerById() throws Exception {
        UUID id = UUID.randomUUID();
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(id);

        when(customerService.getCustomerById(eq(id))).thenReturn(customerDto);

        mockMvc.perform(get("/api/customer/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id.toString()));

        verify(customerService, times(1)).getCustomerById(eq(id));
    }

    @Test
    public void testCreateCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setPhone("1234567890");

        doNothing().when(customerService).createCustomer(any(Customer.class));

        mockMvc.perform(post("/api/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\": \"John\", \"lastName\": \"Doe\", \"phone\": \"1234567890\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Клиент успешно добавлен"));

        verify(customerService, times(1)).createCustomer(any(Customer.class));
    }

    @Test
    public void testDeleteCustomerById() throws Exception {
        UUID id = UUID.randomUUID();
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(id);

        when(customerService.getCustomerById(eq(id))).thenReturn(customerDto);
        doNothing().when(customerService).deleteCustomerById(eq(customerDto));

        mockMvc.perform(delete("/api/customer/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().string("Пользователь удален"));

        verify(customerService, times(1)).getCustomerById(eq(id));
        verify(customerService, times(1)).deleteCustomerById(eq(customerDto));
    }

    @Test
    public void testUpdateCustomerById() throws Exception {
        UUID id = UUID.randomUUID();
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setPhone("1234567890");

        doNothing().when(customerService).updateCustomerById(eq("John"), eq("Doe"), eq("1234567890"), eq(id));

        mockMvc.perform(put("/api/customer/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\": \"John\", \"lastName\": \"Doe\", \"phone\": \"1234567890\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Пользователь обновлен"));

        verify(customerService, times(1)).updateCustomerById(eq("John"), eq("Doe"), eq("1234567890"), eq(id));
    }

    @Test
    public void testGetAllCustomers() throws Exception {
        List<CustomerDto> customers = new ArrayList<>();
        CustomerDto customerDto1 = new CustomerDto();
        customerDto1.setId(UUID.randomUUID());
        customers.add(customerDto1);

        CustomerDto customerDto2 = new CustomerDto();
        customerDto2.setId(UUID.randomUUID());
        customers.add(customerDto2);

        when(customerService.getAllCustomers()).thenReturn(customers);

        mockMvc.perform(get("/api/customer"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(customerDto1.getId().toString()))
                .andExpect(jsonPath("$[1].id").value(customerDto2.getId().toString()));

        verify(customerService, times(1)).getAllCustomers();
    }
}
