package com.pleo.backend.api;

import com.pleo.backend.model.PriceResponse;
import com.pleo.backend.service.PriceFormatterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class PriceFormatterController {

    private static final Logger logger = LoggerFactory.getLogger(PriceFormatterController.class);

    @Autowired
    private PriceFormatterService priceFormatterService;

    @PostMapping(value = "/formatPrice", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity formatPrice(@RequestBody String price) {
        logger.info("Attempt to format price {}", price);
        return ResponseEntity.ok(new PriceResponse(priceFormatterService.formatPrice(price)));
    }
}
