package com.example.client.service;

import com.example.client.dto.BeerGetDto;
import com.example.client.dto.BeerPostDto;
import com.example.client.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
public class BeerClientService {

    // getBeer method => GET
    public void getBeer() {
        WebClient webClient = WebClient.builder().build();
        // WebClient Builder 패턴처럼 사용

        String url = "https://random-data-api.com/api/v2/beers";
        // 어떤 HTTP 메서드로 요청을 보낼지를 get(), post() 메서드 등으로 결정
        // 만일 다른 메서드를 쓰고 싶다면, method()
        BeerGetDto response = webClient.get() // webClient.method(HttpMethod.GET)
                .uri(url) // 요청 경로 설정
                .header("x-test", "header") // 요청 헤더 추가
                // body 도 메서드에 따라 추가
                .retrieve() // 여기 전까지는 요청을 정의한 부분
                // 여기부터 정의하는건 응답을 어떻게 처리할 것인가?
                .bodyToMono(BeerGetDto.class) // 응답이 한번 들어올 것이며, 그 응답의 body 를 String 으로 해석함
                .block(); // 동기식으로 처리하겠다
        log.info(response.toString());
    }

    // postBeer method
    public void postBeer() {
        WebClient webClient = WebClient.builder().baseUrl("http://localhost:8081").build();

        BeerPostDto dto = new BeerPostDto();

        // post 요청 시작
        MessageDto responseBody = webClient.post()
                // url 정의
                .uri("/give-me-beer")
                // requestBody 정의
                .bodyValue(dto)
                // 응답 정의 시작
                .retrieve()
                // 응답 데이터 정의
                .bodyToMono(MessageDto.class)
                // 동기식 처리
                .block();
        log.info(responseBody.toString());
    }

    // postBeer204 method
    public void postBeer204() {
        WebClient webClient = WebClient.builder().build();
        String url = "http://localhost:8081/give-me-beer";

        BeerPostDto dto = new BeerPostDto();
        ResponseEntity<Void> response = webClient.post()
                .uri(url)
                .bodyValue(dto)
                .retrieve()
                .toBodilessEntity() // 응답 Body 가 없을 경우 사용
                .block();

        log.info(response.getStatusCode().toString());
    }
}
