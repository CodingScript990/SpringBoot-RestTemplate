package com.example.client.service;

import com.example.client.dto.BeerGetDto;
import com.example.client.dto.BeerPostDto;
import com.example.client.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

// import request : HTTP library

// api HTTP Request 하는 방법
@Slf4j
@Service
public class BeerRestService {
    // getBeerObject method => getForObject (다른거 필요 없고, 응답 Body 만 있으면 될때)
    public void getBeerObject() {
        // RestTemplate : Spring 에서 제공하는 기본 HTTP Client
        RestTemplate restTemplate = new RestTemplate();
        // api url
        String url = "https://random-data-api.com/api/v2/beers";


        // RestTemplate GET method[직렬화]
        /*
        String responseBody = restTemplate.getForObject(url, String.class);
        log.info(responseBody);
         */

        // @RequestBody, @ResponseBody => JSON -> DTO
        BeerGetDto reBeerGetDto = restTemplate.getForObject(url, BeerGetDto.class);

        log.info(reBeerGetDto.toString());
    }

    // getBeerEntity method => Entity
    public void getBeerEntity() {
        RestTemplate restTemplate = new RestTemplate();
        // api url
        String url = "https://random-data-api.com/api/v2/beers";

        // RestController
        ResponseEntity<BeerGetDto> response = restTemplate.getForEntity(url, BeerGetDto.class);

        // Status line
        log.info(response.getStatusCode().toString());
        // Response header
        log.info(response.getHeaders().toString());
        // Response body
        log.info(response.getBody().toString());
    }

    // postBeerObject method => POST[url]
    // postForObject
    public void postBeerObject() {
        // RestTemplate: Spring 에서 제공하는 기본 HTTP Client
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/give-me-beer";

        BeerPostDto dto = new BeerPostDto();
        dto.setName("Stella Artois");
        dto.setCc(2000L);
        dto.setAlcohol(5.0);

        // post 요청을 보낼 때 requestBody를 같이 전달
        MessageDto responseBody = restTemplate.postForObject(
                url,  // 요청 URL
                dto,  // request Body
                MessageDto.class  // 응답 해석 타입
        );
        log.info(responseBody.toString());

        // 응답 Body 없이 응답하는 URL
        url = "http://localhost:8081/give-me-beer-204";
        ResponseEntity<Void> response = restTemplate.postForEntity(
                url,
                dto,
                Void.class  // void 의 클래스 (객체화 불가)
        );
        log.info(response.getStatusCode().toString());
    }
}
