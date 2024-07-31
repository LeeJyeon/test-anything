package com.example.anything.controller;

import com.example.anything.feign.TestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
@EnableAsync
@Slf4j
public class TestService {

    @Autowired
    TestClient testClient;

    @Async
    public CompletableFuture<String> printService(long timer) {
        log.info("Async Start");

        var response = testClient.getHttp(timer);
        log.info("response : {}", response);

        log.info("Async End");
        return CompletableFuture.completedFuture("AsyncReturn");
    }


    public int addNumber(int target, int addNum) {
        return target + addNum;
    }
}
