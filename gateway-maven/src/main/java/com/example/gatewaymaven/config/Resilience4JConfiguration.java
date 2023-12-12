package com.example.gatewaymaven.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Slf4j
@Configuration
public class Resilience4JConfiguration {

    @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {
        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
                .circuitBreakerConfig(CircuitBreakerConfig.custom()
                        .slidingWindowSize(4)  // Number of requests for analysis
                        .permittedNumberOfCallsInHalfOpenState(5) // The number of normal calls allowed in the half open state
                        .failureRateThreshold(50) // When the call failure rate reaches 50% within the unit time window, the circuit breaker will be started
                        .waitDurationInOpenState(Duration.ofSeconds(10)) // It takes 10 seconds for the circuit breaker to change from open state to half open state
                        .recordExceptions(Throwable.class) // All exceptions are treated as failures
                        .enableAutomaticTransitionFromOpenToHalfOpen()
                        .build())
                .build());
    }
}
