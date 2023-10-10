package com.example.theoryservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TheoryConfig {
    @Bean
    public RestTemplate restTemplate(@Value("${url.rating-service}") String ratingService, RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder
                .rootUri(ratingService)
                .build();
    }
}
