package ru.relex.gateway.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Darya Stupak
 * Класс-фильтр
 * Логирует запрашиваемый путь
 */
@Component
public class RouteInfoFilter implements GlobalFilter {
    Logger logger = LoggerFactory.getLogger(RouteInfoFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Path of the request received -> {}", exchange.getRequest().getPath());
        return chain.filter(exchange);
    }
}
