package com.cgi.d4g.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "CITY_DIGITAL_SCORING", schema = "d4g_ifn", catalog = "")
public class CityDigitalScoring {
    private long cdsId;
    private Integer cdsLegalPopulation;
    private BigDecimal cdsNetworkRateCoverage;
    private BigDecimal cdsMobilityCoverageRate2G;
    private BigDecimal cdsPovertyRate;
    private BigDecimal cdsMedianIncome;
    private BigDecimal cdsSingleParent;
    private BigDecimal cdsSingle;
    private BigDecimal cdsPublicServicePerPerson;
    private BigDecimal cdsPublicService;
    private BigDecimal cdsJobless15To64;
    private BigDecimal cdsPersonAged15To29;
    private BigDecimal cdsPersonAgedOver65;
    private BigDecimal cdsNoDiplomaOver15;
    private long cdsCityId;
    private BigDecimal cdsDigitalInterface;
    private BigDecimal cdsInformationAccess;
    private BigDecimal cdsAdministrationSkill;
    private BigDecimal cdsDigitalSkill;

    @Id
    @Column(name = "CDS_ID", nullable = false)
    public long getCdsId() {
        return cdsId;
    }

    public void setCdsId(long cdsId) {
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
    public BigDecimal getCdsSingleParent() {
        return cdsSingleParent;
    }

    public void setCdsSingleParent(BigDecimal cdsSingleParent) {
        this.cdsSingleParent = cdsSingleParent;
    }

    @Basic
    @Column(name = "CDS_SINGLE", nullable = true, precision = 0)
    public BigDecimal getCdsSingle() {
        return cdsSingle;
    }

    public void setCdsSingle(BigDecimal cdsSingle) {
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
    public BigDecimal getCdsJobless15To64() {
        return cdsJobless15To64;
    }

    public void setCdsJobless15To64(BigDecimal cdsJobless15To64) {
        this.cdsJobless15To64 = cdsJobless15To64;
    }

    @Basic
    @Column(name = "CDS_PERSON_AGED_15_TO_29", nullable = true, precision = 0)
    public BigDecimal getCdsPersonAged15To29() {
        return cdsPersonAged15To29;
    }

    public void setCdsPersonAged15To29(BigDecimal cdsPersonAged15To29) {
        this.cdsPersonAged15To29 = cdsPersonAged15To29;
    }

    @Basic
    @Column(name = "CDS_PERSON_AGED_OVER_65", nullable = true, precision = 0)
    public BigDecimal getCdsPersonAgedOver65() {
        return cdsPersonAgedOver65;
    }

    public void setCdsPersonAgedOver65(BigDecimal cdsPersonAgedOver65) {
        this.cdsPersonAgedOver65 = cdsPersonAgedOver65;
    }

    @Basic
    @Column(name = "CDS_NO_DIPLOMA_OVER_15", nullable = true, precision = 0)
    public BigDecimal getCdsNoDiplomaOver15() {
        return cdsNoDiplomaOver15;
    }

    public void setCdsNoDiplomaOver15(BigDecimal cdsNoDiplomaOver15) {
        this.cdsNoDiplomaOver15 = cdsNoDiplomaOver15;
    }

    @Basic
    @Column(name = "CDS_CITY_ID", nullable = false)
    public long getCdsCityId() {
        return cdsCityId;
    }

    public void setCdsCityId(long cdsCityId) {
        this.cdsCityId = cdsCityId;
    }


    @Basic
    @Column(name = "CDS_DIGITAL_INTERFACE", nullable = true, precision = 4)
    public BigDecimal getCdsDigitalInterface() {
        return cdsDigitalInterface;
    }

    public void setCdsDigitalInterface(BigDecimal cdsDigitalInterface) {
        this.cdsDigitalInterface = cdsDigitalInterface;
    }

    @Basic
    @Column(name = "CDS_INFORMATION_ACCESS", nullable = true, precision = 4)
    public BigDecimal getCdsInformationAccess() {
        return cdsInformationAccess;
    }

    public void setCdsInformationAccess(BigDecimal cdsInformationAccess) {
        this.cdsInformationAccess = cdsInformationAccess;
    }

    @Basic
    @Column(name = "CDS_ADMISTRATION_SKILL", nullable = true, precision = 4)
    public BigDecimal getCdsAdministrationSkill() {
        return cdsAdministrationSkill;
    }

    public void setCdsAdministrationSkill(BigDecimal cdsAdministrationSkill) {
        this.cdsAdministrationSkill = cdsAdministrationSkill;
    }

    @Basic
    @Column(name = "CDS_DIGITAL_SCRILL", nullable = true, precision = 4)
    public BigDecimal getCdsDigitalSkill() {
        return cdsDigitalSkill;
    }

    public void setCdsDigitalSkill(BigDecimal cdsDigitalSkill) {
        this.cdsDigitalSkill = cdsDigitalSkill;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdsAdministrationSkill == null) ? 0 : cdsAdministrationSkill.hashCode());
		result = prime * result + (int) (cdsCityId ^ (cdsCityId >>> 32));
		result = prime * result + ((cdsDigitalInterface == null) ? 0 : cdsDigitalInterface.hashCode());
		result = prime * result + ((cdsDigitalSkill == null) ? 0 : cdsDigitalSkill.hashCode());
		result = prime * result + (int) (cdsId ^ (cdsId >>> 32));
		result = prime * result + ((cdsInformationAccess == null) ? 0 : cdsInformationAccess.hashCode());
		result = prime * result + ((cdsJobless15To64 == null) ? 0 : cdsJobless15To64.hashCode());
		result = prime * result + ((cdsLegalPopulation == null) ? 0 : cdsLegalPopulation.hashCode());
		result = prime * result + ((cdsMedianIncome == null) ? 0 : cdsMedianIncome.hashCode());
		result = prime * result + ((cdsMobilityCoverageRate2G == null) ? 0 : cdsMobilityCoverageRate2G.hashCode());
		result = prime * result + ((cdsNetworkRateCoverage == null) ? 0 : cdsNetworkRateCoverage.hashCode());
		result = prime * result + ((cdsNoDiplomaOver15 == null) ? 0 : cdsNoDiplomaOver15.hashCode());
		result = prime * result + ((cdsPersonAged15To29 == null) ? 0 : cdsPersonAged15To29.hashCode());
		result = prime * result + ((cdsPersonAgedOver65 == null) ? 0 : cdsPersonAgedOver65.hashCode());
		result = prime * result + ((cdsPovertyRate == null) ? 0 : cdsPovertyRate.hashCode());
		result = prime * result + ((cdsPublicService == null) ? 0 : cdsPublicService.hashCode());
		result = prime * result + ((cdsPublicServicePerPerson == null) ? 0 : cdsPublicServicePerPerson.hashCode());
		result = prime * result + ((cdsSingle == null) ? 0 : cdsSingle.hashCode());
		result = prime * result + ((cdsSingleParent == null) ? 0 : cdsSingleParent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CityDigitalScoring other = (CityDigitalScoring) obj;
		if (cdsAdministrationSkill == null) {
			if (other.cdsAdministrationSkill != null)
				return false;
		} else if (!cdsAdministrationSkill.equals(other.cdsAdministrationSkill))
			return false;
		if (cdsCityId != other.cdsCityId)
			return false;
		if (cdsDigitalInterface == null) {
			if (other.cdsDigitalInterface != null)
				return false;
		} else if (!cdsDigitalInterface.equals(other.cdsDigitalInterface))
			return false;
		if (cdsDigitalSkill == null) {
			if (other.cdsDigitalSkill != null)
				return false;
		} else if (!cdsDigitalSkill.equals(other.cdsDigitalSkill))
			return false;
		if (cdsId != other.cdsId)
			return false;
		if (cdsInformationAccess == null) {
			if (other.cdsInformationAccess != null)
				return false;
		} else if (!cdsInformationAccess.equals(other.cdsInformationAccess))
			return false;
		if (cdsJobless15To64 == null) {
			if (other.cdsJobless15To64 != null)
				return false;
		} else if (!cdsJobless15To64.equals(other.cdsJobless15To64))
			return false;
		if (cdsLegalPopulation == null) {
			if (other.cdsLegalPopulation != null)
				return false;
		} else if (!cdsLegalPopulation.equals(other.cdsLegalPopulation))
			return false;
		if (cdsMedianIncome == null) {
			if (other.cdsMedianIncome != null)
				return false;
		} else if (!cdsMedianIncome.equals(other.cdsMedianIncome))
			return false;
		if (cdsMobilityCoverageRate2G == null) {
			if (other.cdsMobilityCoverageRate2G != null)
				return false;
		} else if (!cdsMobilityCoverageRate2G.equals(other.cdsMobilityCoverageRate2G))
			return false;
		if (cdsNetworkRateCoverage == null) {
			if (other.cdsNetworkRateCoverage != null)
				return false;
		} else if (!cdsNetworkRateCoverage.equals(other.cdsNetworkRateCoverage))
			return false;
		if (cdsNoDiplomaOver15 == null) {
			if (other.cdsNoDiplomaOver15 != null)
				return false;
		} else if (!cdsNoDiplomaOver15.equals(other.cdsNoDiplomaOver15))
			return false;
		if (cdsPersonAged15To29 == null) {
			if (other.cdsPersonAged15To29 != null)
				return false;
		} else if (!cdsPersonAged15To29.equals(other.cdsPersonAged15To29))
			return false;
		if (cdsPersonAgedOver65 == null) {
			if (other.cdsPersonAgedOver65 != null)
				return false;
		} else if (!cdsPersonAgedOver65.equals(other.cdsPersonAgedOver65))
			return false;
		if (cdsPovertyRate == null) {
			if (other.cdsPovertyRate != null)
				return false;
		} else if (!cdsPovertyRate.equals(other.cdsPovertyRate))
			return false;
		if (cdsPublicService == null) {
			if (other.cdsPublicService != null)
				return false;
		} else if (!cdsPublicService.equals(other.cdsPublicService))
			return false;
		if (cdsPublicServicePerPerson == null) {
			if (other.cdsPublicServicePerPerson != null)
				return false;
		} else if (!cdsPublicServicePerPerson.equals(other.cdsPublicServicePerPerson))
			return false;
		if (cdsSingle == null) {
			if (other.cdsSingle != null)
				return false;
		} else if (!cdsSingle.equals(other.cdsSingle))
			return false;
		if (cdsSingleParent == null) {
			if (other.cdsSingleParent != null)
				return false;
		} else if (!cdsSingleParent.equals(other.cdsSingleParent))
			return false;
		return true;
	}

}
