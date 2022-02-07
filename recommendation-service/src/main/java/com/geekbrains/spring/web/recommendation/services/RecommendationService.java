package com.geekbrains.spring.web.recommendation.services;
import com.geekbrains.spring.web.api.core.ProductDto;
import com.geekbrains.spring.web.api.recommendation.RecommendationDto;
import com.geekbrains.spring.web.recommendation.converters.RecommendationConverter;
import com.geekbrains.spring.web.recommendation.repositories.RecommendationsRepository;
import lombok.RequiredArgsConstructor;
import org.influxdb.dto.Point;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class RecommendationService {
	private final RecommendationsRepository recommendationsRepository;
	private final RecommendationConverter recommendationConverter;

	public void addToRecommendation(RecommendationDto recommendationDto, String type) {
		recommendationsRepository.addToRecommendation(recommendationDto, type);
	}

	public List<RecommendationDto> getFromRecommendation(String type) {
		return recommendationsRepository.getFromRecommendation(type).stream().map(el->recommendationConverter.entityToDto(el)).collect(Collectors.toList());
	}
}
