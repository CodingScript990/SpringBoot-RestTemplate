package com.example.client.service;

import com.example.client.client.BeerClient;
import com.example.client.client.BeerRestClient;
import com.example.client.client.BeerWebClient;
import com.example.client.dto.BeerGetDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BeerService {
    // Service 는 맥주정보를 어떻게 가져왔는지 중요하지 않음
//    private final BeerRestClient beerRestClient;
//    private final BeerWebClient webClient;
    private final BeerClient client;

    public BeerService(
            //BeerClient client
            @Qualifier("beerRestClient")
            BeerClient client

    ) {
        this.client = client;
    }

    // drinkBeer method => beerRestClient
    public void drinkBeer() {
        log.info("order beer");
        BeerGetDto result = client.getBeer();
        // 핵심은 맥주 정보
        // 맥주 정보를 받아오는 방법은 비즈니스 로직에서 벗어났다
        // 할수 있지 않을까?
        log.info("{}는 맛있다", result.getName());
    }

    // drinkBeer method => webClient
    /*
    public void drinkBeer2() {
        log.info("order beer");
        BeerGetDto result2 = webClient.getBeer();
        log.info("{}는 맛있다", result2.getName());
    }
     */
}
