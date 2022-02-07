package com.geekbrains.spring.web.recommendation.controllers;

import com.geekbrains.spring.web.api.core.ProductDto;
import com.geekbrains.spring.web.api.recommendation.RecommendationDto;
import com.geekbrains.spring.web.recommendation.services.RecommendationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recommendation")
@RequiredArgsConstructor
@Slf4j
public class RecommendationController {
    private final RecommendationService recommendationService;

    @PostMapping("/{type}")
    public void addToRecommendation(@RequestBody RecommendationDto recommendationDto, @PathVariable String type) {
            recommendationService.addToRecommendation(recommendationDto,type);
    }

    @GetMapping("/{type}")
    public List<RecommendationDto> getFromRecommendation(@PathVariable String type) {
        log.info("recommendation {}",type);
        return recommendationService.getFromRecommendation(type);
    }
}
