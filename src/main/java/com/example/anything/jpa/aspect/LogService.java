package com.example.anything.jpa.aspect;

import com.example.anything.jpa.entity.Customer;
import com.example.anything.jpa.repository.CustomerRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class LogService {

    private final CustomerRepository customerRepository;

    public LogService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void logging(Object args, boolean isSuccess) {
        Customer customer = new Customer();
        if (isSuccess) {
            customer.setName("success log - " + args.toString());
        } else {
            customer.setName("error log - " + args.toString());
        }
        customerRepository.save(customer);
    }
}

