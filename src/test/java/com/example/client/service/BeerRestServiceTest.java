package com.example.client.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerRestServiceTest {

    // Service call
    @Autowired
    private BeerRestService service;

    // TDD => HTTP Request url
    @Test
    @DisplayName("HTTP Request url test")
    public void testGetBeerObject() {
        service.getBeerObject();
    }

    // TDD => HTTP Request entity
    @Test
    @DisplayName("HTTP Request entity test")
    public void testGetBeerEntity() {
        service.getBeerEntity();
    }

    // TDD => HTTP Request Post url test
    @Test
    @DisplayName("HTTP Request Post url test")
    public void testPostBeerObject() {
        service.postBeerObject();
    }
}