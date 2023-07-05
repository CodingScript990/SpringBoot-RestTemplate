package com.example.client.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BeerClientServiceTest {

    @Autowired
    private BeerClientService beerClientService;

    @Test
    @DisplayName("HTTP GET Method[getBeer]")
    public void getBeerTest() {
        beerClientService.getBeer();
    }

    @Test
    @DisplayName("HTTP POST Method[postBeer]")
    public void postBeerTest() {
        beerClientService.postBeer();
    }

    @Test
    @DisplayName("HTTP POST Method[post204Beer]")
    public void postBeer204Test() {
        beerClientService.postBeer204();
    }
}