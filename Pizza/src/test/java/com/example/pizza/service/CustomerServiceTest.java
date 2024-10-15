package com.example.pizza.service;

import com.example.pizza.model.Customer;
import com.example.pizza.model.dto.CustomerDto;
import com.example.pizza.repository.CustomerRepository;
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

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    private Customer customer;
    private CustomerDto customerDto;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        customer = new Customer();
        customer.setId(UUID.randomUUID());
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setPhone("123456789");

        customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setPhone(customer.getPhone());
    }

    @Test
    public void testGetCustomerById() {
        when(customerRepository.findById(customer.getId())).thenReturn(Optional.of(customer));

        CustomerDto foundCustomerDto = customerService.getCustomerById(customer.getId());

        assertNotNull(foundCustomerDto);
        assertEquals(customer.getId(), foundCustomerDto.getId());
        assertEquals(customer.getFirstName(), foundCustomerDto.getFirstName());

        verify(customerRepository, times(1)).findById(customer.getId());
    }

    @Test
    public void testCreateCustomer() {
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        customerService.createCustomer(customer);

        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    public void testDeleteCustomerById() {
        doNothing().when(customerRepository).delete(any(Customer.class));

        customerService.deleteCustomerById(customerDto);

        verify(customerRepository, times(1)).delete(any(Customer.class));
    }

    @Test
    public void testUpdateCustomerById() {
        when(customerRepository.findById(customer.getId())).thenReturn(Optional.of(customer));
        customerService.updateCustomerById("Jane", "Doe", "987654321", customer.getId());

        assertEquals("Jane", customer.getFirstName());
        assertEquals("Doe", customer.getLastName());
        assertEquals("987654321", customer.getPhone());

        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    public void testGetAllCustomers() {
        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer));

        List<CustomerDto> customerDtos = customerService.getAllCustomers();

        assertNotNull(customerDtos);
        assertEquals(1, customerDtos.size());
        assertEquals(customer.getId(), customerDtos.get(0).getId());

        verify(customerRepository, times(1)).findAll();
    }
}
