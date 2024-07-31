package com.example.anything.jpa.service;

import com.example.anything.jpa.entity.Customer;
import com.example.anything.jpa.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class JpaService {

    private final CustomerRepository customerRepository;

    public JpaService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Customer saveData(String name) {
        if (name.equals("Mr.Error")) {
            throw new RuntimeException();
        }

        Customer customer = new Customer();
        customer.setName(name);
        return customerRepository.save(customer);
    }
}
