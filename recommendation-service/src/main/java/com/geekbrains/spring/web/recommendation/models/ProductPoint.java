package com.geekbrains.spring.web.recommendation.models;

import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

import java.time.Instant;

@Measurement(name = "purchased")
public class ProductPoint {
	public Instant getTime() {
		return time;
	}

	public void setTime(Instant time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "time")
	private Instant time;

	@Column(name = "title")
	private String title;

	@Column(name = "type")
	private String type;

	@Column(name = "quantity")
	private Integer quantity;

}
