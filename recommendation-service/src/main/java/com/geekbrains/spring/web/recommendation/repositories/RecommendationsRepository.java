package com.geekbrains.spring.web.recommendation.repositories;


import com.geekbrains.spring.web.api.core.ProductDto;
import com.geekbrains.spring.web.api.recommendation.RecommendationDto;
import com.geekbrains.spring.web.recommendation.models.ProductPoint;
import com.geekbrains.spring.web.recommendation.services.RecommendationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.influxdb.InfluxDB;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.influxdb.impl.InfluxDBResultMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RecommendationsRepository  {

    private final InfluxDB influxDB;

    public void addToRecommendation(RecommendationDto recommendationDto, String type) {

       influxDB.write(Point.measurement("purchased")
                .time(System.currentTimeMillis(),TimeUnit.MILLISECONDS)
                .tag("title", recommendationDto.getTitle())
		        .tag("type", type)
                .addField("quantity", recommendationDto.getQuantity())
                .build());
    }

	public List<ProductPoint> getFromRecommendation(String type) {

    	String duration = type.equals("added")?"1d":"4w";

    	String query = String.format("SELECT top(q, 5) as quantity, title FROM (SELECT sum(quantity) as q FROM purchased WHERE time > now() - %s AND type = '%s' GROUP BY title)", duration, type);

    	log.info("Query {}", query);

		QueryResult queryResult = influxDB.query(new Query(query));

		InfluxDBResultMapper resultMapper = new InfluxDBResultMapper();
		List<ProductPoint> mostPurchasedProducts = resultMapper
				.toPOJO(queryResult, ProductPoint.class);

		return mostPurchasedProducts;
	}
}
