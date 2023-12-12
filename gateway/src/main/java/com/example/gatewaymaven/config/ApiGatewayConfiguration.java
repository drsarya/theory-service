package com.example.gatewaymaven.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
    @Value(value = "${url.rating-service}")
    private String ratingService;

    @Value(value = "${url.theory-service}")
    private String theoryService;

    @Value(value = "${url.statistic-service}")
    private String statisticService;

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder locatorBuilder) {
        return locatorBuilder
                .routes()
                .route(p -> p
                        .path("/api/theory/**")
                        .filters(v -> v.circuitBreaker((c) -> {
                            c.setName("theoryCircuitBreaker");
                        }))
                        .uri(theoryService))
                .route(p -> p
                        .path("/api/statistic/**")
                        .filters(v -> v.circuitBreaker((c) -> {
                            c.setName("statisticCircuitBreaker");
                        }))
                        .uri(statisticService))
                .build();
    }
}
