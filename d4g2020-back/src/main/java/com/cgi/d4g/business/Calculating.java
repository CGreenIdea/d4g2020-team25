package com.cgi.d4g.business;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Calculating {

    private static final int SCALE = 2;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.CEILING;
    private static final BigDecimal POINT_VALUE = BigDecimal.valueOf(100);
    private static final BigDecimal MULTIPLIER_INIT = BigDecimal.valueOf(1);
    private static final BigDecimal PUBLIC_SERVICE_INIT = BigDecimal.valueOf(2);
    private static final BigDecimal PUBLIC_SERVICE_COMPARATOR = BigDecimal.valueOf(0);
    private static final BigDecimal PUBLIC_SERVICE_DEFAULT = BigDecimal.valueOf(0);
    private static final BigDecimal HAD_AND_MOBILE_INIT = BigDecimal.valueOf(1);
    private static final BigDecimal SCORE_BASE = BigDecimal.valueOf(100);

    private Calculating() {
    }

    public static BigDecimal defaultMultiplierCoefficient(BigDecimal value, BigDecimal threshold) {
        return MULTIPLIER_INIT.subtract(value).divide(threshold, SCALE, ROUNDING_MODE);
    }

    public static BigDecimal publicServiceMultiplierCoefficient(BigDecimal value, BigDecimal threshold) {
        BigDecimal baseMultiplier = PUBLIC_SERVICE_INIT.subtract(defaultMultiplierCoefficient(value, threshold));

        return baseMultiplier.compareTo(PUBLIC_SERVICE_COMPARATOR) < 0 ? PUBLIC_SERVICE_DEFAULT : baseMultiplier;
    }

    public static BigDecimal hdAndMobileMultiplierCoefficient(BigDecimal value, BigDecimal threshold) {
        return HAD_AND_MOBILE_INIT.subtract(value).divide(threshold, SCALE, ROUNDING_MODE);
    }

    public static BigDecimal point(BigDecimal value) {
        return value.multiply(POINT_VALUE);
    }

    public static BigDecimal numericInterfaceAccessScore(BigDecimal networkRateCoveragePoint, BigDecimal mobilityCoverageRatePoint, BigDecimal povertyRatePoint, BigDecimal medianIncomePoint) {
        return networkRateCoveragePoint.add(mobilityCoverageRatePoint).add(povertyRatePoint).add(medianIncomePoint);
    }

    public static BigDecimal informationAccessScore(BigDecimal singleParentPoint, BigDecimal singlePoint, BigDecimal publicServicePerPersonPoint) {
        return singleParentPoint.add(singlePoint).add(publicServicePerPersonPoint);
    }

    public static BigDecimal globalAccessScore(BigDecimal numericAccessScore, BigDecimal informationAccessScore) {
        return numericAccessScore.add(informationAccessScore);
    }

    public static BigDecimal administrativeSkillsScore(BigDecimal jobless15To64Point, BigDecimal personAged15To29Point) {
        return jobless15To64Point.add(personAged15To29Point);
    }

    public static BigDecimal digitalSchoolSkillsScore(BigDecimal personAgedOver65Point, BigDecimal personNoDiplomaOver15Point) {
        return personAgedOver65Point.add(personNoDiplomaOver15Point);
    }

    public static BigDecimal globalCompetencesScore(BigDecimal administrativeSkillsScore, BigDecimal digitalSchoolSkillsScore) {
        return administrativeSkillsScore.add(digitalSchoolSkillsScore);
    }

    public static BigDecimal globalScore(BigDecimal globalAccessScore, BigDecimal globalCompetencesScore) {
        return globalAccessScore.add(globalCompetencesScore);
    }

    public static BigDecimal numericInterfaceAccessScoreBase(BigDecimal numericInterfaceAccessScore) {
        return getScoreBase(numericInterfaceAccessScore, 4);
    }

    public static BigDecimal informationAccessScoreBase(BigDecimal informationAccessScore) {
        return getScoreBase(informationAccessScore, 3);
    }

    public static BigDecimal globalAccessScoreBase(BigDecimal globalAccessScore) {
        return getScoreBase(globalAccessScore, 7);
    }

    public static BigDecimal administrativeSkillsScoreBase(BigDecimal administrativeSkillsScore) {
        return getScoreBase(administrativeSkillsScore, 2);
    }

    public static BigDecimal digitalSchoolSkillsScoreBase(BigDecimal digitalSchoolSkillsScore) {
        return getScoreBase(digitalSchoolSkillsScore, 2);
    }

    public static BigDecimal globalCompetencesScoreBase(BigDecimal globalCompetencesScore) {
        return getScoreBase(globalCompetencesScore, 4);
    }

    public static BigDecimal globalScoreBase(BigDecimal globalScore) {
        return getScoreBase(globalScore, 11);
    }

    private static BigDecimal getScoreBase(BigDecimal score, int numberScore) {
        return score.multiply(SCORE_BASE).divide(BigDecimal.valueOf(numberScore).multiply(SCORE_BASE), SCALE, ROUNDING_MODE);
    }

    public static int getQuintiles(BigDecimal scoreBase, BigDecimal thresholdTwo, BigDecimal thresholdThree, BigDecimal thresholdFour, BigDecimal thresholdFive) {
        if (scoreBase.compareTo(thresholdTwo) < 0) {
            return 1;
        } else if (scoreBase.compareTo(thresholdTwo) >= 0 && scoreBase.compareTo(thresholdThree) < 0) {
            return 2;
        } else if (scoreBase.compareTo(thresholdThree) >= 0 && scoreBase.compareTo(thresholdFour) < 0) {
            return 3;
        } else if (scoreBase.compareTo(thresholdFour) >= 0 && scoreBase.compareTo(thresholdFive) < 0) {
            return 4;
        } else {
            return 5;
        }
    }

}
