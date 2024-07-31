package com.example.anything.feign;

import com.example.anything.dto.CustomResponse;
import com.example.anything.dto.ResponseForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestClientTest {

    @Autowired
    TestClient testClient;

    @Test
    public void tester() {
        ResponseForm<CustomResponse> response =
                testClient.getHttp(1);

        System.out.println(response.toString());
        System.out.println(response.responseHeader.toString());
        System.out.println(response.responseData.toString());

    }

}