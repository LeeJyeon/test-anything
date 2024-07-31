package com.example.anything.feign;

import com.example.anything.dto.CustomResponse;
import com.example.anything.dto.ResponseForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "custom", url = "localhost:3000")
public interface TestClient {

    @GetMapping("/{timer}")
    ResponseForm<CustomResponse> getHttp(@PathVariable("timer") long timer);

}
