package com.cgi.d4g.business;

import com.cgi.d4g.entity.CityDigitalScoring;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Calculating {

    private static final int SCALE = 2;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
    private static final BigDecimal POINT_VALUE = BigDecimal.valueOf(100);
    private static final BigDecimal MULTIPLIER_INIT = BigDecimal.valueOf(1);
    private static final BigDecimal PUBLIC_SERVICE_INIT = BigDecimal.valueOf(2);
    private static final BigDecimal PUBLIC_SERVICE_COMPARATOR = BigDecimal.valueOf(0);
    private static final BigDecimal PUBLIC_SERVICE_DEFAULT = BigDecimal.valueOf(0);
    private static final BigDecimal HD_AND_MOBILE_INIT = BigDecimal.valueOf(1);
    private static final BigDecimal SCORE_BASE = BigDecimal.valueOf(100);

    private Calculating() {
    }

    public static void updateScoreBaseOfScoring(CityDigitalScoring scoring, CityDigitalScoring threshold) {
        BigDecimal network = hdAndMobileMultiplierCoefficient(scoring.getCdsNetworkRateCoverage(), threshold.getCdsNetworkRateCoverage());
        BigDecimal mobile = hdAndMobileMultiplierCoefficient(scoring.getCdsMobilityCoverageRate2G(), threshold.getCdsMobilityCoverageRate2G());
        BigDecimal poverty = defaultMultiplierCoefficient(scoring.getCdsPovertyRate(), threshold.getCdsPovertyRate());
        BigDecimal median = defaultMultiplierCoefficient(scoring.getCdsMedianIncome(), threshold.getCdsMedianIncome());

        BigDecimal single = defaultMultiplierCoefficient(scoring.getCdsSingle(), threshold.getCdsSingle());
        BigDecimal singleParent = defaultMultiplierCoefficient(scoring.getCdsSingleParent(), threshold.getCdsSingleParent());
        BigDecimal publicServicePerPerson = publicServiceMultiplierCoefficient(scoring.getCdsPublicServicePerPerson(), threshold.getCdsPublicServicePerPerson());

        BigDecimal jobless = defaultMultiplierCoefficient(scoring.getCdsJobless15To64(), threshold.getCdsJobless15To64());
        BigDecimal personAged15To29 = defaultMultiplierCoefficient(scoring.getCdsPersonAged15To29(), threshold.getCdsPersonAged15To29());
        BigDecimal personAgedOver65 = defaultMultiplierCoefficient(scoring.getCdsPersonAgedOver65(), threshold.getCdsPersonAgedOver65());
        BigDecimal noDiploma = defaultMultiplierCoefficient(scoring.getCdsNoDiplomaOver15(), threshold.getCdsNoDiplomaOver15());

        BigDecimal digitalInterfaceAccessScore = digitalInterfaceAccessScore(
            point(network),
            point(mobile),
            point(poverty),
            point(median)
        );

        BigDecimal informationAccessScore = informationAccessScore(
            point(singleParent),
            point(single),
            point(publicServicePerPerson)
        );

        BigDecimal administrativeSkillsScore = administrativeSkillsScore(
            point(jobless),
            point(personAged15To29)
        );

        BigDecimal digitalSchoolSkillsScore = digitalSchoolSkillsScore(
            point(personAgedOver65),
            point(noDiploma)
        );

        scoring.setCdsDigitalInterface(digitalInterfaceAccessScoreBase(digitalInterfaceAccessScore));
        scoring.setCdsInformationAccess(informationAccessScoreBase(informationAccessScore));
        scoring.setCdsAdministrationSkill(administrativeSkillsScoreBase(administrativeSkillsScore));
        scoring.setCdsDigitalSkill(digitalSchoolSkillsScoreBase(digitalSchoolSkillsScore));
    }

    /**
     * ((value - threshold) / threshold) + 1
     */
    private static BigDecimal defaultMultiplierCoefficient(BigDecimal value, BigDecimal threshold) {
        return value.subtract(threshold).divide(threshold, SCALE, ROUNDING_MODE).add(MULTIPLIER_INIT);
    }

    /**
     * IF 2 - (((value - threshold) / threshold) + 1) < 0 ? 0 : 2 - (((value - threshold) / threshold) + 1)
     */
    private static BigDecimal publicServiceMultiplierCoefficient(BigDecimal value, BigDecimal threshold) {
        if(value == null){
            value = BigDecimal.ZERO;
        }
        BigDecimal baseMultiplier = PUBLIC_SERVICE_INIT.subtract(defaultMultiplierCoefficient(value, threshold));

        return baseMultiplier.compareTo(PUBLIC_SERVICE_COMPARATOR) < 0 ? PUBLIC_SERVICE_DEFAULT : baseMultiplier;
    }

    /**
     * (1 - value ) / threshold
     */
    private static BigDecimal hdAndMobileMultiplierCoefficient(BigDecimal value, BigDecimal threshold) {
        return HD_AND_MOBILE_INIT.subtract(value).divide(threshold, SCALE, ROUNDING_MODE);
    }

    /**
     * value * 100
     */
    private static BigDecimal point(BigDecimal value) {
        return value.multiply(POINT_VALUE);
    }

    /**
     * Simple addition of values
     */
    private static BigDecimal digitalInterfaceAccessScore(BigDecimal networkRateCoveragePoint, BigDecimal mobilityCoverageRatePoint, BigDecimal povertyRatePoint, BigDecimal medianIncomePoint) {
        return networkRateCoveragePoint.add(mobilityCoverageRatePoint).add(povertyRatePoint).add(medianIncomePoint);
    }

    /**
     * Simple addition of values
     */
    private static BigDecimal informationAccessScore(BigDecimal singleParentPoint, BigDecimal singlePoint, BigDecimal publicServicePerPersonPoint) {
        return singleParentPoint.add(singlePoint).add(publicServicePerPersonPoint);
    }

    /**
     * Simple addition of values
     */
    private static BigDecimal administrativeSkillsScore(BigDecimal jobless15To64Point, BigDecimal personAged15To29Point) {
        return jobless15To64Point.add(personAged15To29Point);
    }

    /**
     * Simple addition of values
     */
    private static BigDecimal digitalSchoolSkillsScore(BigDecimal personAgedOver65Point, BigDecimal personNoDiplomaOver15Point) {
        return personAgedOver65Point.add(personNoDiplomaOver15Point);
    }

    /**
     * Simple addition of values
     */
    private static BigDecimal digitalInterfaceAccessScoreBase(BigDecimal digitalInterfaceAccessScore) {
        return getScoreBase(digitalInterfaceAccessScore, 4);
    }

    /**
     * (score * 100) / (3 * 100)
     */
    private static BigDecimal informationAccessScoreBase(BigDecimal informationAccessScore) {
        return getScoreBase(informationAccessScore, 3);
    }

    /**
     * (score * 100) / (2 * 100)
     */
    private static BigDecimal administrativeSkillsScoreBase(BigDecimal administrativeSkillsScore) {
        return getScoreBase(administrativeSkillsScore, 2);
    }

    /**
     * (score * 100) / (2 * 100)
     */
    private static BigDecimal digitalSchoolSkillsScoreBase(BigDecimal digitalSchoolSkillsScore) {
        return getScoreBase(digitalSchoolSkillsScore, 2);
    }

    /**
     * (score * 100) / (lengthScore * 100)
     */
    private static BigDecimal getScoreBase(BigDecimal score, int numberScore) {
        return score.multiply(SCORE_BASE).divide(BigDecimal.valueOf(numberScore).multiply(SCORE_BASE), SCALE, ROUNDING_MODE);
    }

}
