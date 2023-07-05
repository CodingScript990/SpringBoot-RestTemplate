package com.example.client.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BeerServiceTest {

    @Autowired
    private BeerService beerService;

    @Test
    public void drinkBeer() {
        beerService.drinkBeer();
    }

    /*
    @Test
    public void drinkBeer2() {
        beerService.drinkBeer2();
    }
     */
}