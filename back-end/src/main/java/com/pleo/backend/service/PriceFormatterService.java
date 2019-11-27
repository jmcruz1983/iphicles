package com.pleo.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

@Component
public class PriceFormatterService {

    private static final Logger logger = LoggerFactory.getLogger(PriceFormatterService.class);

    private DecimalFormat dfDecimal;

    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public PriceFormatterService() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(' ');
        symbols.setDecimalSeparator('.');
        dfDecimal = new DecimalFormat("0.00");
        dfDecimal.setGroupingSize(3);
        dfDecimal.setDecimalFormatSymbols(symbols);
        dfDecimal.setGroupingUsed(true);
    }

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public String formatPrice(String price) {
        logger.info("formatPrice({})", price);
        if(isNumeric(price)) {
            return dfDecimal.format(Double.parseDouble(price));
        }
        return "NaN";
    }
}
