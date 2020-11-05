package com.cgi.d4g.business.model;

import java.math.BigDecimal;
import java.util.Objects;

public class RegionDigitalScoringModel {
    private Integer cdrLegalPopulation;
    private BigDecimal cdrNetworkRateCoverage;
    private BigDecimal cdrMobilityCoverageRate2G;
    private BigDecimal cdrPovertyRate;
    private BigDecimal cdrMedianIncome;
    private Integer cdrSingleParent;
    private Integer cdrSingle;
    private BigDecimal cdrPublicServicePerPerson;
    private BigDecimal cdrPublicService;
    private Integer cdrJobless15To64;
    private Integer cdrPersonAged15To29;
    private Integer cdrPersonAgedOver65;
    private Integer cdrNoDiplomaOver15;
    private int cdrDepartementId;


    public Integer getCddLegalPopulation() {
        return cdrLegalPopulation;
    }

    public void setCddLegalPopulation(Integer cdrLegalPopulation) {
        this.cdrLegalPopulation = cdrLegalPopulation;
    }

    public BigDecimal getCddNetworkRateCoverage() {
        return cdrNetworkRateCoverage;
    }

    public void setCddNetworkRateCoverage(BigDecimal cdrNetworkRateCoverage) {
        this.cdrNetworkRateCoverage = cdrNetworkRateCoverage;
    }

    public BigDecimal getCddMobilityCoverageRate2G() {
        return cdrMobilityCoverageRate2G;
    }

    public void setCddMobilityCoverageRate2G(BigDecimal cdrMobilityCoverageRate2G) {
        this.cdrMobilityCoverageRate2G = cdrMobilityCoverageRate2G;
    }

    public BigDecimal getCddPovertyRate() {
        return cdrPovertyRate;
    }

    public void setCddPovertyRate(BigDecimal cdrPovertyRate) {
        this.cdrPovertyRate = cdrPovertyRate;
    }

    public BigDecimal getCddMedianIncome() {
        return cdrMedianIncome;
    }

    public void setCddMedianIncome(BigDecimal cdrMedianIncome) {
        this.cdrMedianIncome = cdrMedianIncome;
    }

    public Integer getCddSingleParent() {
        return cdrSingleParent;
    }

    public void setCddSingleParent(Integer cdrSingleParent) {
        this.cdrSingleParent = cdrSingleParent;
    }

    public Integer getCddSingle() {
        return cdrSingle;
    }

    public void setCddSingle(Integer cdrSingle) {
        this.cdrSingle = cdrSingle;
    }

    public BigDecimal getCddPublicServicePerPerson() {
        return cdrPublicServicePerPerson;
    }

    public void setCddPublicServicePerPerson(BigDecimal cdrPublicServicePerPerson) {
        this.cdrPublicServicePerPerson = cdrPublicServicePerPerson;
    }

    public BigDecimal getCddPublicService() {
        return cdrPublicService;
    }

    public void setCddPublicService(BigDecimal cdrPublicService) {
        this.cdrPublicService = cdrPublicService;
    }

    public Integer getCddJobless15To64() {
        return cdrJobless15To64;
    }

    public void setCddJobless15To64(Integer cdrJobless15To64) {
        this.cdrJobless15To64 = cdrJobless15To64;
    }

    public Integer getCddPersonAged15To29() {
        return cdrPersonAged15To29;
    }

    public void setCddPersonAged15To29(Integer cdrPersonAged15To29) {
        this.cdrPersonAged15To29 = cdrPersonAged15To29;
    }

    public Integer getCddPersonAgedOver65() {
        return cdrPersonAgedOver65;
    }

    public void setCddPersonAgedOver65(Integer cdrPersonAgedOver65) {
        this.cdrPersonAgedOver65 = cdrPersonAgedOver65;
    }

    public Integer getCddNoDiplomaOver15() {
        return cdrNoDiplomaOver15;
    }

    public void setCddNoDiplomaOver15(Integer cdrNoDiplomaOver15) {
        this.cdrNoDiplomaOver15 = cdrNoDiplomaOver15;
    }

    public int getCddDepartementId() {
        return cdrDepartementId;
    }

    public void setCddDepartementId(int cdrDepartementId) {
        this.cdrDepartementId = cdrDepartementId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RegionDigitalScoringModel that = (RegionDigitalScoringModel) o;
        return 
            cdrDepartementId == that.cdrDepartementId &&
            Objects.equals(cdrLegalPopulation, that.cdrLegalPopulation) &&
            Objects.equals(cdrNetworkRateCoverage, that.cdrNetworkRateCoverage) &&
            Objects.equals(cdrMobilityCoverageRate2G, that.cdrMobilityCoverageRate2G) &&
            Objects.equals(cdrPovertyRate, that.cdrPovertyRate) &&
            Objects.equals(cdrMedianIncome, that.cdrMedianIncome) &&
            Objects.equals(cdrSingleParent, that.cdrSingleParent) &&
            Objects.equals(cdrSingle, that.cdrSingle) &&
            Objects.equals(cdrPublicServicePerPerson, that.cdrPublicServicePerPerson) &&
            Objects.equals(cdrPublicService, that.cdrPublicService) &&
            Objects.equals(cdrJobless15To64, that.cdrJobless15To64) &&
            Objects.equals(cdrPersonAged15To29, that.cdrPersonAged15To29) &&
            Objects.equals(cdrPersonAgedOver65, that.cdrPersonAgedOver65) &&
            Objects.equals(cdrNoDiplomaOver15, that.cdrNoDiplomaOver15);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cdrLegalPopulation, cdrNetworkRateCoverage, cdrMobilityCoverageRate2G, cdrPovertyRate, cdrMedianIncome, cdrSingleParent, cdrSingle, cdrPublicServicePerPerson, cdrPublicService, cdrJobless15To64, cdrPersonAged15To29, cdrPersonAgedOver65, cdrNoDiplomaOver15, cdrDepartementId);
    }
}
