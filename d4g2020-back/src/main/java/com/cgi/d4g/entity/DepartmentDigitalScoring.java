package com.cgi.d4g.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "DEPARTMENT_DIGITAL_SCORING", schema = "d4g_ifn", catalog = "")
public class DepartmentDigitalScoring {
    private long cddId;
    private Integer cddLegalPopulation;
    private BigDecimal cddNetworkRateCoverage;
    private BigDecimal cddMobilityCoverageRate2G;
    private BigDecimal cddPovertyRate;
    private BigDecimal cddMedianIncome;
    private Integer cddSingleParent;
    private Integer cddSingle;
    private BigDecimal cddPublicServicePerPerson;
    private BigDecimal cddPublicService;
    private Integer cddJobless15To64;
    private Integer cddPersonAged15To29;
    private Integer cddPersonAgedOver65;
    private Integer cddNoDiplomaOver15;
    private long cddDepartementId;

    @Id
    @Column(name = "CDD_ID", nullable = false)
    public long getCddId() {
        return cddId;
    }

    public void setCddId(long cddId) {
        this.cddId = cddId;
    }

    @Basic
    @Column(name = "CDD_LEGAL_POPULATION", nullable = true)
    public Integer getCddLegalPopulation() {
        return cddLegalPopulation;
    }

    public void setCddLegalPopulation(Integer cddLegalPopulation) {
        this.cddLegalPopulation = cddLegalPopulation;
    }

    @Basic
    @Column(name = "CDD_NETWORK_RATE_COVERAGE", nullable = true, precision = 4)
    public BigDecimal getCddNetworkRateCoverage() {
        return cddNetworkRateCoverage;
    }

    public void setCddNetworkRateCoverage(BigDecimal cddNetworkRateCoverage) {
        this.cddNetworkRateCoverage = cddNetworkRateCoverage;
    }

    @Basic
    @Column(name = "CDD_MOBILITY_COVERAGE_RATE_2G", nullable = true, precision = 4)
    public BigDecimal getCddMobilityCoverageRate2G() {
        return cddMobilityCoverageRate2G;
    }

    public void setCddMobilityCoverageRate2G(BigDecimal cddMobilityCoverageRate2G) {
        this.cddMobilityCoverageRate2G = cddMobilityCoverageRate2G;
    }

    @Basic
    @Column(name = "CDD_POVERTY_RATE", nullable = true, precision = 4)
    public BigDecimal getCddPovertyRate() {
        return cddPovertyRate;
    }

    public void setCddPovertyRate(BigDecimal cddPovertyRate) {
        this.cddPovertyRate = cddPovertyRate;
    }

    @Basic
    @Column(name = "CDD_MEDIAN_INCOME", nullable = true, precision = 4)
    public BigDecimal getCddMedianIncome() {
        return cddMedianIncome;
    }

    public void setCddMedianIncome(BigDecimal cddMedianIncome) {
        this.cddMedianIncome = cddMedianIncome;
    }

    @Basic
    @Column(name = "CDD_SINGLE_PARENT", nullable = true, precision = 0)
    public Integer getCddSingleParent() {
        return cddSingleParent;
    }

    public void setCddSingleParent(Integer cddSingleParent) {
        this.cddSingleParent = cddSingleParent;
    }

    @Basic
    @Column(name = "CDD_SINGLE", nullable = true, precision = 0)
    public Integer getCddSingle() {
        return cddSingle;
    }

    public void setCddSingle(Integer cddSingle) {
        this.cddSingle = cddSingle;
    }

    @Basic
    @Column(name = "CDD_PUBLIC_SERVICE_PER_PERSON", nullable = true, precision = 4)
    public BigDecimal getCddPublicServicePerPerson() {
        return cddPublicServicePerPerson;
    }

    public void setCddPublicServicePerPerson(BigDecimal cddPublicServicePerPerson) {
        this.cddPublicServicePerPerson = cddPublicServicePerPerson;
    }

    @Basic
    @Column(name = "CDD_PUBLIC_SERVICE", nullable = true, precision = 4)
    public BigDecimal getCddPublicService() {
        return cddPublicService;
    }

    public void setCddPublicService(BigDecimal cddPublicService) {
        this.cddPublicService = cddPublicService;
    }

    @Basic
    @Column(name = "CDD_JOBLESS_15_TO_64", nullable = true, precision = 0)
    public Integer getCddJobless15To64() {
        return cddJobless15To64;
    }

    public void setCddJobless15To64(Integer cddJobless15To64) {
        this.cddJobless15To64 = cddJobless15To64;
    }

    @Basic
    @Column(name = "CDD_PERSON_AGED_15_TO_29", nullable = true, precision = 0)
    public Integer getCddPersonAged15To29() {
        return cddPersonAged15To29;
    }

    public void setCddPersonAged15To29(Integer cddPersonAged15To29) {
        this.cddPersonAged15To29 = cddPersonAged15To29;
    }

    @Basic
    @Column(name = "CDD_PERSON_AGED_OVER_65", nullable = true, precision = 0)
    public Integer getCddPersonAgedOver65() {
        return cddPersonAgedOver65;
    }

    public void setCddPersonAgedOver65(Integer cddPersonAgedOver65) {
        this.cddPersonAgedOver65 = cddPersonAgedOver65;
    }

    @Basic
    @Column(name = "CDD_NO_DIPLOMA_OVER_15", nullable = true, precision = 0)
    public Integer getCddNoDiplomaOver15() {
        return cddNoDiplomaOver15;
    }

    public void setCddNoDiplomaOver15(Integer cddNoDiplomaOver15) {
        this.cddNoDiplomaOver15 = cddNoDiplomaOver15;
    }

    @Basic
    @Column(name = "CDD_DEPARTEMENT_ID", nullable = false)
    public long getCddDepartementId() {
        return cddDepartementId;
    }

    public void setCddDepartementId(long cddDepartementId) {
        this.cddDepartementId = cddDepartementId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DepartmentDigitalScoring that = (DepartmentDigitalScoring) o;
        return cddId == that.cddId &&
            cddDepartementId == that.cddDepartementId &&
            Objects.equals(cddLegalPopulation, that.cddLegalPopulation) &&
            Objects.equals(cddNetworkRateCoverage, that.cddNetworkRateCoverage) &&
            Objects.equals(cddMobilityCoverageRate2G, that.cddMobilityCoverageRate2G) &&
            Objects.equals(cddPovertyRate, that.cddPovertyRate) &&
            Objects.equals(cddMedianIncome, that.cddMedianIncome) &&
            Objects.equals(cddSingleParent, that.cddSingleParent) &&
            Objects.equals(cddSingle, that.cddSingle) &&
            Objects.equals(cddPublicServicePerPerson, that.cddPublicServicePerPerson) &&
            Objects.equals(cddPublicService, that.cddPublicService) &&
            Objects.equals(cddJobless15To64, that.cddJobless15To64) &&
            Objects.equals(cddPersonAged15To29, that.cddPersonAged15To29) &&
            Objects.equals(cddPersonAgedOver65, that.cddPersonAgedOver65) &&
            Objects.equals(cddNoDiplomaOver15, that.cddNoDiplomaOver15);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cddId, cddLegalPopulation, cddNetworkRateCoverage, cddMobilityCoverageRate2G, cddPovertyRate, cddMedianIncome, cddSingleParent, cddSingle, cddPublicServicePerPerson, cddPublicService, cddJobless15To64, cddPersonAged15To29, cddPersonAgedOver65, cddNoDiplomaOver15, cddDepartementId);
    }
}
