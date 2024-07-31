package com.example.anything.jpa.repository;

import com.example.anything.jpa.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void 테스트합니다() {
        Customer customer = new Customer();
        customer.setName("jihyun");
        Customer savedCustomer = customerRepository.save(customer);

        var dbCustomer = customerRepository.findById(savedCustomer.getId());

        System.out.println(dbCustomer.toString());
    }
}