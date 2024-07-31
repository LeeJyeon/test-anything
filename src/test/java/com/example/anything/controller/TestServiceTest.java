package com.example.anything.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestServiceTest {


    @Test
    public void test() {

        TestService testService = new TestService();

        if (testService.addNumber(1, 2) != 3) {
            fail();
        }
    }

}