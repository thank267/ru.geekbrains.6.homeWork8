package com.geekbrains.spring.web.api.recommendation;

import com.geekbrains.spring.web.api.core.ProductDto;

public class RecommendationDto {
    private String title;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public RecommendationDto() {
    }

    public RecommendationDto(String title, int quantity) {
        this.title = title;
        this.quantity = quantity;
    }
}
