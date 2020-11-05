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
    private static final BigDecimal HD_AND_MOBILE_INIT = BigDecimal.valueOf(1);
    private static final BigDecimal SCORE_BASE = BigDecimal.valueOf(100);

    private Calculating() {
    }

    /**
     * ((value - threshold) / threshold) + 1
     */
    public static BigDecimal defaultMultiplierCoefficient(BigDecimal value, BigDecimal threshold) {
        return value.subtract(threshold).divide(threshold, SCALE, ROUNDING_MODE).add(MULTIPLIER_INIT);
    }

    /**
     * IF 2 - (((value - threshold) / threshold) + 1) < 0 ? 0 : 2 - (((value - threshold) / threshold) + 1)
     */
    public static BigDecimal publicServiceMultiplierCoefficient(BigDecimal value, BigDecimal threshold) {
        BigDecimal baseMultiplier = PUBLIC_SERVICE_INIT.subtract(defaultMultiplierCoefficient(value, threshold));

        return baseMultiplier.compareTo(PUBLIC_SERVICE_COMPARATOR) < 0 ? PUBLIC_SERVICE_DEFAULT : baseMultiplier;
    }

    /**
     * (1 - value ) / threshold
     */
    public static BigDecimal hdAndMobileMultiplierCoefficient(BigDecimal value, BigDecimal threshold) {
        return HD_AND_MOBILE_INIT.subtract(value).divide(threshold, SCALE, ROUNDING_MODE);
    }

    /**
     * value * 100
     */
    public static BigDecimal point(BigDecimal value) {
        return value.multiply(POINT_VALUE);
    }

    /**
     * Simple addition of values
     */
    public static BigDecimal numericInterfaceAccessScore(BigDecimal networkRateCoveragePoint, BigDecimal mobilityCoverageRatePoint, BigDecimal povertyRatePoint, BigDecimal medianIncomePoint) {
        return networkRateCoveragePoint.add(mobilityCoverageRatePoint).add(povertyRatePoint).add(medianIncomePoint);
    }

    /**
     * Simple addition of values
     */
    public static BigDecimal informationAccessScore(BigDecimal singleParentPoint, BigDecimal singlePoint, BigDecimal publicServicePerPersonPoint) {
        return singleParentPoint.add(singlePoint).add(publicServicePerPersonPoint);
    }

    /**
     * Simple addition of values
     */
    public static BigDecimal globalAccessScore(BigDecimal numericAccessScore, BigDecimal informationAccessScore) {
        return numericAccessScore.add(informationAccessScore);
    }

    /**
     * Simple addition of values
     */
    public static BigDecimal administrativeSkillsScore(BigDecimal jobless15To64Point, BigDecimal personAged15To29Point) {
        return jobless15To64Point.add(personAged15To29Point);
    }

    /**
     * Simple addition of values
     */
    public static BigDecimal digitalSchoolSkillsScore(BigDecimal personAgedOver65Point, BigDecimal personNoDiplomaOver15Point) {
        return personAgedOver65Point.add(personNoDiplomaOver15Point);
    }

    /**
     * Simple addition of values
     */
    public static BigDecimal globalCompetencesScore(BigDecimal administrativeSkillsScore, BigDecimal digitalSchoolSkillsScore) {
        return administrativeSkillsScore.add(digitalSchoolSkillsScore);
    }

    /**
     * Simple addition of values
     */
    public static BigDecimal globalScore(BigDecimal globalAccessScore, BigDecimal globalCompetencesScore) {
        return globalAccessScore.add(globalCompetencesScore);
    }

    /**
     * Simple addition of values
     */
    public static BigDecimal numericInterfaceAccessScoreBase(BigDecimal numericInterfaceAccessScore) {
        return getScoreBase(numericInterfaceAccessScore, 4);
    }

    /**
     * (score * 100) / (3 * 100)
     */
    public static BigDecimal informationAccessScoreBase(BigDecimal informationAccessScore) {
        return getScoreBase(informationAccessScore, 3);
    }

    /**
     * (score * 100) / (7 * 100)
     */
    public static BigDecimal globalAccessScoreBase(BigDecimal globalAccessScore) {
        return getScoreBase(globalAccessScore, 7);
    }

    /**
     * (score * 100) / (2 * 100)
     */
    public static BigDecimal administrativeSkillsScoreBase(BigDecimal administrativeSkillsScore) {
        return getScoreBase(administrativeSkillsScore, 2);
    }

    /**
     * (score * 100) / (2 * 100)
     */
    public static BigDecimal digitalSchoolSkillsScoreBase(BigDecimal digitalSchoolSkillsScore) {
        return getScoreBase(digitalSchoolSkillsScore, 2);
    }

    /**
     * (score * 100) / (4 * 100)
     */
    public static BigDecimal globalCompetencesScoreBase(BigDecimal globalCompetencesScore) {
        return getScoreBase(globalCompetencesScore, 4);
    }

    /**
     * (score * 100) / (11 * 100)
     */
    public static BigDecimal globalScoreBase(BigDecimal globalScore) {
        return getScoreBase(globalScore, 11);
    }

    /**
     * (score * 100) / (lengthScore * 100)
     */
    private static BigDecimal getScoreBase(BigDecimal score, int numberScore) {
        return score.multiply(SCORE_BASE).divide(BigDecimal.valueOf(numberScore).multiply(SCORE_BASE), SCALE, ROUNDING_MODE);
    }

}
