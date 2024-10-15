package com.example.pizza.service;


import com.example.pizza.model.Customer;
import com.example.pizza.model.dto.CustomerDto;
import com.example.pizza.repository.CustomerRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerDto getCustomerById(UUID id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        return ConvertDtoToCustomer(customer);
    }

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomerById(CustomerDto customerDto){
        Customer customer = ConvertCustomerDtoToCustomer(customerDto);
        customerRepository.delete(customer);
    }
    public void updateCustomerById(String firstName, String lastName, @NonNull String phone, UUID id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Пользователя не существует " + id));
       customer.setFirstName(firstName);
       customer.setLastName(lastName);
       customer.setPhone(String.valueOf(phone));
       customerRepository.save(customer);
    }
    public List<CustomerDto> getAllCustomers () {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(this::ConvertDtoToCustomer).collect(Collectors.toList());
    }

    private CustomerDto ConvertDtoToCustomer(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setId(customer.getId());
        customerDto.setPhone(customer.getPhone());
        return customerDto;
    }

    private Customer ConvertCustomerDtoToCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setId(customerDto.getId());
        customer.setPhone(customerDto.getPhone());
        return customer;
    }
}
