package com.pleo.backend.service;

import org.junit.Test;
import org.junit.Before;

import static junit.framework.TestCase.assertEquals;

public class PriceFormatterServiceTest {

    private PriceFormatterService priceFormatterService;

    @Before
    public void setup() {
        priceFormatterService = new PriceFormatterService();
    }

    @Test
    public void formatEmptyPrice() {
        assertEquals(priceFormatterService.formatPrice(""), "NaN");
    }

    @Test
    public void formatNullPrice() {
        assertEquals(priceFormatterService.formatPrice(null), "NaN");
    }

    @Test
    public void formatZeroPrice() {
        assertEquals(priceFormatterService.formatPrice("0"), "0.00");
    }

    @Test
    public void formatIntegerPrice() {
        assertEquals(priceFormatterService.formatPrice("1600"), "1 600.00");
    }

    @Test
    public void formatLongIntegerPrice() {
        assertEquals(priceFormatterService.formatPrice("123543321123000"), "123 543 321 123 000.00");
    }

    @Test
    public void formatNegativeIntegerPrice() {
        assertEquals(priceFormatterService.formatPrice("-1600"), "-1 600.00");
    }

    @Test
    public void formatDecimalPrice() {
        assertEquals(priceFormatterService.formatPrice("2310000.159897"), "2 310 000.16");
    }

    @Test
    public void formatLongDecimalPrice() {
        assertEquals(priceFormatterService.formatPrice("123543321123000.159897"), "123 543 321 123 000.16");
    }

    @Test
    public void formatOneDecimalPositionPrice() {
        assertEquals(priceFormatterService.formatPrice("1600.1"), "1 600.10");
    }

    @Test
    public void formatNegativePrice() {
        assertEquals(priceFormatterService.formatPrice("-2310000.159897"), "-2 310 000.16");
    }

    @Test
    public void formatStringPrice() {
        assertEquals(priceFormatterService.formatPrice("hello"), "NaN");
    }
}
