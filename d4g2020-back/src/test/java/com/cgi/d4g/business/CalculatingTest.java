package com.cgi.d4g.business;

import com.cgi.d4g.entity.CityDigitalScoring;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CalculatingTest {

    @Test
    void testUpdateScoreBaseOfScoring() {
        CityDigitalScoring threshold = new CityDigitalScoring();
        threshold.setCdsNetworkRateCoverage(BigDecimal.valueOf(0.963072693824679));
        threshold.setCdsMobilityCoverageRate2G(BigDecimal.valueOf(0.969671609678614));
        threshold.setCdsPovertyRate(BigDecimal.valueOf(0.172));
        threshold.setCdsMedianIncome(BigDecimal.valueOf(19672));
        threshold.setCdsSingleParent(BigDecimal.valueOf(0.159));
        threshold.setCdsSingle(BigDecimal.valueOf(0.37));
        threshold.setCdsPublicServicePerPerson(BigDecimal.valueOf(0.000351261251592481));
        threshold.setCdsJobless15To64(BigDecimal.valueOf(0.11));
        threshold.setCdsPersonAged15To29(BigDecimal.valueOf(0.17));
        threshold.setCdsPersonAgedOver65(BigDecimal.valueOf(0.217));
        threshold.setCdsNoDiplomaOver15(BigDecimal.valueOf(0.287));

        CityDigitalScoring scoring = new CityDigitalScoring();
        scoring.setCdsNetworkRateCoverage(BigDecimal.valueOf(0.997));
        scoring.setCdsMobilityCoverageRate2G(BigDecimal.valueOf(1));
        scoring.setCdsPovertyRate(BigDecimal.valueOf(0.13));
        scoring.setCdsMedianIncome(BigDecimal.valueOf(25277));
        scoring.setCdsSingleParent(BigDecimal.valueOf(0.119));
        scoring.setCdsSingle(BigDecimal.valueOf(0.191));
        scoring.setCdsJobless15To64(BigDecimal.valueOf(0.0716395864106352));
        scoring.setCdsPersonAged15To29(BigDecimal.valueOf(0.126845891707686));
        scoring.setCdsPersonAgedOver65(BigDecimal.valueOf(0.117));
        scoring.setCdsNoDiplomaOver15(BigDecimal.valueOf(0.162));

        Calculating.updateScoreBaseOfScoring(scoring, threshold);

        BigDecimal digitalInterfaceScoreBase = BigDecimal.valueOf(51);
        BigDecimal informationAccessScoreBase = BigDecimal.valueOf(109);
        BigDecimal administrationSkillScoreBase = BigDecimal.valueOf(70);
        BigDecimal digitalSkillScoreBase = BigDecimal.valueOf(55);

        Assertions.assertEquals(0, scoring.getCdsDigitalInterface().compareTo(digitalInterfaceScoreBase));
        Assertions.assertEquals(0, scoring.getCdsInformationAccess().compareTo(informationAccessScoreBase));
        Assertions.assertEquals(0, scoring.getCdsAdministrationSkill().compareTo(administrationSkillScoreBase));
        Assertions.assertEquals(0, scoring.getCdsDigitalSkill().compareTo(digitalSkillScoreBase));

    }
}
