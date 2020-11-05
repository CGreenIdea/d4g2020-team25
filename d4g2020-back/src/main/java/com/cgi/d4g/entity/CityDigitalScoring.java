package com.cgi.d4g.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "CITY_DIGITAL_SCORING", schema = "d4g_ifn", catalog = "")
public class CityDigitalScoring {
    private int cdsId;
    private Integer cdsLegalPopulation;
    private BigDecimal cdsNetworkRateCoverage;
    private BigDecimal cdsMobilityCoverageRate2G;
    private BigDecimal cdsPovertyRate;
    private BigDecimal cdsMedianIncome;
    private Integer cdsSingleParent;
    private Integer cdsSingle;
    private BigDecimal cdsPublicServicePerPerson;
    private BigDecimal cdsPublicService;
    private Integer cdsJobless15To64;
    private Integer cdsPersonAged15To29;
    private Integer cdsPersonAgedOver65;
    private Integer cdsNoDiplomaOver15;
    private int cdsCityId;

    @Id
    @Column(name = "CDS_ID", nullable = false)
    public int getCdsId() {
        return cdsId;
    }

    public void setCdsId(int cdsId) {
        this.cdsId = cdsId;
    }

    @Basic
    @Column(name = "CDS_LEGAL_POPULATION", nullable = true)
    public Integer getCdsLegalPopulation() {
        return cdsLegalPopulation;
    }

    public void setCdsLegalPopulation(Integer cdsLegalPopulation) {
        this.cdsLegalPopulation = cdsLegalPopulation;
    }

    @Basic
    @Column(name = "CDS_NETWORK_RATE_COVERAGE", nullable = true, precision = 4)
    public BigDecimal getCdsNetworkRateCoverage() {
        return cdsNetworkRateCoverage;
    }

    public void setCdsNetworkRateCoverage(BigDecimal cdsNetworkRateCoverage) {
        this.cdsNetworkRateCoverage = cdsNetworkRateCoverage;
    }

    @Basic
    @Column(name = "CDS_MOBILITY_COVERAGE_RATE_2G", nullable = true, precision = 4)
    public BigDecimal getCdsMobilityCoverageRate2G() {
        return cdsMobilityCoverageRate2G;
    }

    public void setCdsMobilityCoverageRate2G(BigDecimal cdsMobilityCoverageRate2G) {
        this.cdsMobilityCoverageRate2G = cdsMobilityCoverageRate2G;
    }

    @Basic
    @Column(name = "CDS_POVERTY_RATE", nullable = true, precision = 4)
    public BigDecimal getCdsPovertyRate() {
        return cdsPovertyRate;
    }

    public void setCdsPovertyRate(BigDecimal cdsPovertyRate) {
        this.cdsPovertyRate = cdsPovertyRate;
    }

    @Basic
    @Column(name = "CDS_MEDIAN_INCOME", nullable = true, precision = 4)
    public BigDecimal getCdsMedianIncome() {
        return cdsMedianIncome;
    }

    public void setCdsMedianIncome(BigDecimal cdsMedianIncome) {
        this.cdsMedianIncome = cdsMedianIncome;
    }

    @Basic
    @Column(name = "CDS_SINGLE_PARENT", nullable = true, precision = 0)
    public Integer getCdsSingleParent() {
        return cdsSingleParent;
    }

    public void setCdsSingleParent(Integer cdsSingleParent) {
        this.cdsSingleParent = cdsSingleParent;
    }

    @Basic
    @Column(name = "CDS_SINGLE", nullable = true, precision = 0)
    public Integer getCdsSingle() {
        return cdsSingle;
    }

    public void setCdsSingle(Integer cdsSingle) {
        this.cdsSingle = cdsSingle;
    }

    @Basic
    @Column(name = "CDS_PUBLIC_SERVICE_PER_PERSON", nullable = true, precision = 4)
    public BigDecimal getCdsPublicServicePerPerson() {
        return cdsPublicServicePerPerson;
    }

    public void setCdsPublicServicePerPerson(BigDecimal cdsPublicServicePerPerson) {
        this.cdsPublicServicePerPerson = cdsPublicServicePerPerson;
    }

    @Basic
    @Column(name = "CDS_PUBLIC_SERVICE", nullable = true, precision = 4)
    public BigDecimal getCdsPublicService() {
        return cdsPublicService;
    }

    public void setCdsPublicService(BigDecimal cdsPublicService) {
        this.cdsPublicService = cdsPublicService;
    }

    @Basic
    @Column(name = "CDS_JOBLESS_15_TO_64", nullable = true, precision = 0)
    public Integer getCdsJobless15To64() {
        return cdsJobless15To64;
    }

    public void setCdsJobless15To64(Integer cdsJobless15To64) {
        this.cdsJobless15To64 = cdsJobless15To64;
    }

    @Basic
    @Column(name = "CDS_PERSON_AGED_15_TO_29", nullable = true, precision = 0)
    public Integer getCdsPersonAged15To29() {
        return cdsPersonAged15To29;
    }

    public void setCdsPersonAged15To29(Integer cdsPersonAged15To29) {
        this.cdsPersonAged15To29 = cdsPersonAged15To29;
    }

    @Basic
    @Column(name = "CDS_PERSON_AGED_OVER_65", nullable = true, precision = 0)
    public Integer getCdsPersonAgedOver65() {
        return cdsPersonAgedOver65;
    }

    public void setCdsPersonAgedOver65(Integer cdsPersonAgedOver65) {
        this.cdsPersonAgedOver65 = cdsPersonAgedOver65;
    }

    @Basic
    @Column(name = "CDS_NO_DIPLOMA_OVER_15", nullable = true, precision = 0)
    public Integer getCdsNoDiplomaOver15() {
        return cdsNoDiplomaOver15;
    }

    public void setCdsNoDiplomaOver15(Integer cdsNoDiplomaOver15) {
        this.cdsNoDiplomaOver15 = cdsNoDiplomaOver15;
    }

    @Basic
    @Column(name = "CDS_CITY_ID", nullable = false)
    public int getCdsCityId() {
        return cdsCityId;
    }

    public void setCdsCityId(int cdsCityId) {
        this.cdsCityId = cdsCityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CityDigitalScoring that = (CityDigitalScoring) o;
        return cdsId == that.cdsId &&
            cdsCityId == that.cdsCityId &&
            Objects.equals(cdsLegalPopulation, that.cdsLegalPopulation) &&
            Objects.equals(cdsNetworkRateCoverage, that.cdsNetworkRateCoverage) &&
            Objects.equals(cdsMobilityCoverageRate2G, that.cdsMobilityCoverageRate2G) &&
            Objects.equals(cdsPovertyRate, that.cdsPovertyRate) &&
            Objects.equals(cdsMedianIncome, that.cdsMedianIncome) &&
            Objects.equals(cdsSingleParent, that.cdsSingleParent) &&
            Objects.equals(cdsSingle, that.cdsSingle) &&
            Objects.equals(cdsPublicServicePerPerson, that.cdsPublicServicePerPerson) &&
            Objects.equals(cdsPublicService, that.cdsPublicService) &&
            Objects.equals(cdsJobless15To64, that.cdsJobless15To64) &&
            Objects.equals(cdsPersonAged15To29, that.cdsPersonAged15To29) &&
            Objects.equals(cdsPersonAgedOver65, that.cdsPersonAgedOver65) &&
            Objects.equals(cdsNoDiplomaOver15, that.cdsNoDiplomaOver15);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cdsId, cdsLegalPopulation, cdsNetworkRateCoverage, cdsMobilityCoverageRate2G, cdsPovertyRate, cdsMedianIncome, cdsSingleParent, cdsSingle, cdsPublicServicePerPerson, cdsPublicService, cdsJobless15To64, cdsPersonAged15To29, cdsPersonAgedOver65, cdsNoDiplomaOver15, cdsCityId);
    }
}
