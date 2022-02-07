package com.geekbrains.spring.web.recommendation.converters;

import com.geekbrains.spring.web.api.recommendation.RecommendationDto;
import com.geekbrains.spring.web.recommendation.models.ProductPoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RecommendationConverter {

    public RecommendationDto entityToDto(ProductPoint productPoint) {
        return new RecommendationDto(productPoint.getTitle(), productPoint.getQuantity());
    }
}
