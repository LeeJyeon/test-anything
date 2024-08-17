package com.example.anything.controller;

import com.example.anything.feign.TestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@Slf4j
public class TestController {

    @Value("${haha}")
    String opt;

    @Autowired
    TestService testService;

    @GetMapping("/{timer}")
    public String test(@PathVariable(name = "timer") Long timer) throws InterruptedException {
        log.info("test Start");
        Thread.sleep(timer);
        log.info("test End");
        return "OK\n";
    }

    @GetMapping("/do/{timer}/{go}")
    public String doTest(@PathVariable(name = "timer") Long timer, @PathVariable(name = "go") String go
    ) throws ExecutionException, InterruptedException {
        String returnValue = "";

        log.info(Thread.currentThread().getName() + " print Start");
        CompletableFuture<String> cf = testService.printService(timer);
        log.info(Thread.currentThread().getName() + "print end");

        if (go.equals("Y")) {
            returnValue = cf.get();
        }
        return returnValue;
    }

    @GetMapping("/option")
    public String option() {
        return opt;
    }
}
