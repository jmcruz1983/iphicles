package com.pleo.backend.model;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PriceResponseTest {

    @Test
    public void priceResponseGetterTest() {
        PriceResponse priceResponse = new PriceResponse("1234");
        assertEquals(priceResponse.getPrice(), "1234");
    }

    @Test
    public void priceResponseToStringTest() {
        PriceResponse priceResponse = new PriceResponse("1234");
        assertEquals(priceResponse.toString(), "PriceResponse{price=1234}");
    }
}
