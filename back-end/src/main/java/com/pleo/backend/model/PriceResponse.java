package com.pleo.backend.model;

public class PriceResponse {
    public final String price;

    public PriceResponse(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("PriceResponse{price=%s}", price);
    }
}
