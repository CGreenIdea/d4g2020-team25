package com.cgi.d4g.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CalculatingTest {

    private static final BigDecimal PUBLIC_THRESHOLD = BigDecimal.valueOf(0.000351261251592481);
    private static final BigDecimal POVERTY_THRESHOLD = BigDecimal.valueOf(0.172);
    private static final BigDecimal HD_THRESHOLD = BigDecimal.valueOf(0.963072693824679);

    private final static BigDecimal HD = BigDecimal.valueOf(0.991);
    private final static BigDecimal POVERTY = BigDecimal.valueOf(0.13);
    private final static BigDecimal PUBLIC_SERVICE_PER_PERSON = BigDecimal.valueOf(0);

    private final static BigDecimal HD_COEFFICIENT = BigDecimal.valueOf(0.01);
    private final static BigDecimal POVERTY_COEFFICIENT = BigDecimal.valueOf(0.76);
    private final static BigDecimal PUBLIC_SERVICE_PER_PERSON_COEFFICIENT = BigDecimal.valueOf(2);

    private final static BigDecimal HD_POINT = BigDecimal.valueOf(0.31);
    private final static BigDecimal MOBILE_POINT = BigDecimal.valueOf(0);
    private final static BigDecimal POVERTY_POINT = BigDecimal.valueOf(76);
    private final static BigDecimal MEDIAN_POINT = BigDecimal.valueOf(71.51);
    private final static BigDecimal SINGLE_PARENT_POINT = BigDecimal.valueOf(74.84);
    private final static BigDecimal SINGLE_POINT = BigDecimal.valueOf(51.62);
    private final static BigDecimal PUBLIC_SERVICE_PER_PERSON_POINT = BigDecimal.valueOf(200);
    private final static BigDecimal JOBLESS_POINT = BigDecimal.valueOf(65.13);
    private final static BigDecimal PERSON_15_TO_29_POINT = BigDecimal.valueOf(74.62);
    private final static BigDecimal PERSON_OVER_65_POINT = BigDecimal.valueOf(53.92);
    private final static BigDecimal NO_DIPLOMA_POINT = BigDecimal.valueOf(56.45);

    private static final BigDecimal DIGITAL_INTERFACE_ACCESS_SCORE = HD_POINT.add(MOBILE_POINT).add(POVERTY_POINT).add(MEDIAN_POINT);
    private static final BigDecimal INFORMATION_ACCESS_SCORE = SINGLE_PARENT_POINT.add(SINGLE_POINT).add(PUBLIC_SERVICE_PER_PERSON_POINT);
    private static final BigDecimal GLOBAL_ACCESS_SCORE = INFORMATION_ACCESS_SCORE.add(DIGITAL_INTERFACE_ACCESS_SCORE);
    private static final BigDecimal ADMINISTRATIVE_SKILLS_SCORE = JOBLESS_POINT.add(PERSON_15_TO_29_POINT);
    private static final BigDecimal DIGITAL_SCHOOL_SKILLS_SCORE = PERSON_OVER_65_POINT.add(NO_DIPLOMA_POINT);
    private static final BigDecimal GLOBAL_COMPETENCES_SCORE = ADMINISTRATIVE_SKILLS_SCORE.add(DIGITAL_SCHOOL_SKILLS_SCORE);
    private static final BigDecimal GLOBAL_SCORE = GLOBAL_ACCESS_SCORE.add(GLOBAL_COMPETENCES_SCORE);

    private static final BigDecimal DIGITAL_INTERFACE_ACCESS_SCORE_BASE = BigDecimal.valueOf(36.96);
    private static final BigDecimal INFORMATION_ACCESS_SCORE_BASE = BigDecimal.valueOf(108.82);
    private static final BigDecimal GLOBAL_ACCESS_SCORE_BASE = BigDecimal.valueOf(67.76);
    private static final BigDecimal ADMINISTRATIVE_SKILLS_SCORE_BASE = BigDecimal.valueOf(69.88);
    private static final BigDecimal DIGITAL_SCHOOL_SKILLS_SCORE_BASE = BigDecimal.valueOf(55.19);
    private static final BigDecimal GLOBAL_COMPETENCES_SCORE_BASE = BigDecimal.valueOf(62.53);
    private static final BigDecimal GLOBAL_SCORE_BASE = BigDecimal.valueOf(65.86);

    @Test
    void testHdAndMobileMultiplierCoefficient() {
        BigDecimal result = Calculating.hdAndMobileMultiplierCoefficient(HD, HD_THRESHOLD);
        Assertions.assertEquals(0, HD_COEFFICIENT.compareTo(result));
    }

    @Test
    void testDefaultMultiplierCoefficient() {
        BigDecimal result = Calculating.defaultMultiplierCoefficient(POVERTY, POVERTY_THRESHOLD);
        Assertions.assertEquals(0, POVERTY_COEFFICIENT.compareTo(result));
    }

    @Test
    void testPublicServiceMultiplierCoefficient() {
        BigDecimal result = Calculating.publicServiceMultiplierCoefficient(PUBLIC_SERVICE_PER_PERSON, PUBLIC_THRESHOLD);
        Assertions.assertEquals(0, PUBLIC_SERVICE_PER_PERSON_COEFFICIENT.compareTo(result));
    }

    @Test
    void testPoint() {
        BigDecimal result = Calculating.point(POVERTY_COEFFICIENT);
        Assertions.assertEquals(0, POVERTY_POINT.compareTo(result));
    }

    @Test
    void testDigitalInterfaceAccessScore() {
        BigDecimal result = Calculating.digitalInterfaceAccessScore(HD_POINT, MOBILE_POINT, POVERTY_POINT, MEDIAN_POINT);
        Assertions.assertEquals(0, DIGITAL_INTERFACE_ACCESS_SCORE.compareTo(result));
    }

    @Test
    void testInformationAccessScore() {
        BigDecimal result = Calculating.informationAccessScore(SINGLE_PARENT_POINT, SINGLE_POINT, PUBLIC_SERVICE_PER_PERSON_POINT);
        Assertions.assertEquals(0, INFORMATION_ACCESS_SCORE.compareTo(result));
    }

    @Test
    void testGlobalAccessScore() {
        BigDecimal result = Calculating.globalAccessScore(DIGITAL_INTERFACE_ACCESS_SCORE, INFORMATION_ACCESS_SCORE);
        Assertions.assertEquals(0, GLOBAL_ACCESS_SCORE.compareTo(result));
    }

    @Test
    void testAdministrativeSkillsScore() {
        BigDecimal result = Calculating.administrativeSkillsScore(JOBLESS_POINT, PERSON_15_TO_29_POINT);
        Assertions.assertEquals(0, ADMINISTRATIVE_SKILLS_SCORE.compareTo(result));
    }

    @Test
    void testDigitalSchoolSkillsScore() {
        BigDecimal result = Calculating.digitalSchoolSkillsScore(PERSON_OVER_65_POINT, NO_DIPLOMA_POINT);
        Assertions.assertEquals(0, DIGITAL_SCHOOL_SKILLS_SCORE.compareTo(result));
    }

    @Test
    void testGlobalCompetencesScore() {
        BigDecimal result = Calculating.globalCompetencesScore(ADMINISTRATIVE_SKILLS_SCORE, DIGITAL_SCHOOL_SKILLS_SCORE);
        Assertions.assertEquals(0, GLOBAL_COMPETENCES_SCORE.compareTo(result));
    }

    @Test
    void testGlobalScore() {
        BigDecimal result = Calculating.globalScore(GLOBAL_ACCESS_SCORE, GLOBAL_COMPETENCES_SCORE);
        Assertions.assertEquals(0, GLOBAL_SCORE.compareTo(result));
    }

    @Test
    void testDigitalInterfaceAccessScoreBase() {
        BigDecimal result = Calculating.digitalInterfaceAccessScoreBase(DIGITAL_INTERFACE_ACCESS_SCORE);
        Assertions.assertEquals(0, DIGITAL_INTERFACE_ACCESS_SCORE_BASE.compareTo(result));
    }

    @Test
    void testInformationAccessScoreBase() {
        BigDecimal result = Calculating.informationAccessScoreBase(INFORMATION_ACCESS_SCORE);
        Assertions.assertEquals(0, INFORMATION_ACCESS_SCORE_BASE.compareTo(result));
    }

    @Test
    void testGlobalAccessScoreBase() {
        BigDecimal result = Calculating.globalAccessScoreBase(GLOBAL_ACCESS_SCORE);
        Assertions.assertEquals(0, GLOBAL_ACCESS_SCORE_BASE.compareTo(result));
    }

    @Test
    void testAdministrativeSkillsScoreBase() {
        BigDecimal result = Calculating.administrativeSkillsScoreBase(ADMINISTRATIVE_SKILLS_SCORE);
        Assertions.assertEquals(0, ADMINISTRATIVE_SKILLS_SCORE_BASE.compareTo(result));
    }

    @Test
    void testDigitalSchoolSkillsScoreBase() {
        BigDecimal result = Calculating.digitalSchoolSkillsScoreBase(DIGITAL_SCHOOL_SKILLS_SCORE);
        Assertions.assertEquals(0, DIGITAL_SCHOOL_SKILLS_SCORE_BASE.compareTo(result));
    }

    @Test
    void testGlobalCompetencesScoreBase() {
        BigDecimal result = Calculating.globalCompetencesScoreBase(GLOBAL_COMPETENCES_SCORE);
        Assertions.assertEquals(0, GLOBAL_COMPETENCES_SCORE_BASE.compareTo(result));
    }

    @Test
    void testglobalScoreBase() {
        BigDecimal result = Calculating.globalScoreBase(GLOBAL_SCORE);
        Assertions.assertEquals(0, GLOBAL_SCORE_BASE.compareTo(result));
    }

}
