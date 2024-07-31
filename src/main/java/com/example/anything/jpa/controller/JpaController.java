package com.example.anything.jpa.controller;

import com.example.anything.jpa.entity.Customer;
import com.example.anything.jpa.service.JpaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class JpaController {

    private final JpaService jpaService;

    public JpaController(JpaService jpaService) {
        this.jpaService = jpaService;
    }

    @GetMapping("/jpa/{name}")
    public Customer test(@PathVariable(name = "name") String name) {
        return jpaService.saveData(name);
    }
}
