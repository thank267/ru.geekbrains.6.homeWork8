package com.geekbrains.spring.web.core.integrations;

import com.geekbrains.spring.web.api.carts.CartDto;
import com.geekbrains.spring.web.api.core.ProductDto;
import com.geekbrains.spring.web.api.recommendation.RecommendationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RecommendationServiceIntegration {
    private final WebClient recommendationServiceWebClient;

    public void addToRecommendation(ProductDto productDto, Integer quantity, String username) {
        recommendationServiceWebClient.post()
                .uri("/api/v1/recommendation/purchased")
                .header("username", username)
                .body(Mono.just(new RecommendationDto(productDto.getTitle(), quantity)),RecommendationDto.class)
                .retrieve()
                .toBodilessEntity()
                .block();

    }
}
