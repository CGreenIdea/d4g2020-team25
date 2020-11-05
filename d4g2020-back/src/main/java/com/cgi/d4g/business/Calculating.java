package com.cgi.d4g.business;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Calculating {

    public static BigDecimal defaultMultiplierCoefficient(BigDecimal value, BigDecimal threshold) {
        return new BigDecimal(1).subtract(value).divide(threshold, 2, RoundingMode.CEILING);
    }

    public static BigDecimal publicServiceMultiplierCoefficient(BigDecimal value, BigDecimal threshold){
        return null;
    }
}
