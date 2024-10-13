package com.example.pizza.repository;

import com.example.pizza.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Customer findByFirstNameAndLastName(String firstName, String lastName);
}
