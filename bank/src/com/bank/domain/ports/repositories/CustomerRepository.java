package com.bank.domain.ports.repositories;

import com.bank.domain.model.customer.Customer;
import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findById(String id);
    void save(Customer customer);
}