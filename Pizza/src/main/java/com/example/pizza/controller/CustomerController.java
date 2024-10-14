package com.example.pizza.controller;

import com.example.pizza.model.Customer;
import com.example.pizza.model.dto.CustomerDto;
import com.example.pizza.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable UUID id) {
        CustomerDto customer = customerService.getCustomerById(id);
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping()
    public ResponseEntity<String> createOrderById(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return ResponseEntity.ok("Клиент успешно добавлен");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable UUID id) {
        CustomerDto customer = customerService.getCustomerById(id);
        customerService.deleteCustomerById(customer);
        return ResponseEntity.ok("Пользователь удален");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomerById(@PathVariable UUID id, @RequestBody Customer customer) {
        customerService.updateCustomerById(customer.getFirstName(), customer.getLastName(), customer.getPhone(),id);
        return ResponseEntity.ok("Пользователь обновлен");
    }
    @GetMapping()
    public ResponseEntity<List<CustomerDto>> getAllCustomers () {
        List<CustomerDto> customer = customerService.getAllCustomers();
        return ResponseEntity.ok().body(customer);
    }

}
