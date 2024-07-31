package com.example.anything;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AnythingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnythingApplication.class, args);
    }

}
