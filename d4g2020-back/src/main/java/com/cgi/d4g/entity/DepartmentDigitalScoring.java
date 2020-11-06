package com.cgi.d4g.entity;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cgi.d4g.business.model.DepartmentDigitalScoringModel;

@Entity
@Table(name = "DEPARTMENT_DIGITAL_SCORING", schema = "d4g_ifn", catalog = "")
public class DepartmentDigitalScoring {
    private long cddId;
    private Integer cddLegalPopulation;
    private BigDecimal cddNetworkRateCoverage;
    private BigDecimal cddMobilityCoverageRate2G;
    private BigDecimal cddPovertyRate;
    private BigDecimal cddMedianIncome;
    private BigDecimal cddSingleParent;
    private BigDecimal cddSingle;
    private BigDecimal cddPublicServicePerPerson;
    private BigDecimal cddPublicService;
    private BigDecimal cddJobless15To64;
    private BigDecimal cddPersonAged15To29;
    private BigDecimal cddPersonAgedOver65;
    private BigDecimal cddNoDiplomaOver15;
    private long cddDepartementId;
    private BigDecimal cddDigitalInterface;
    private BigDecimal cddInformationAccess;
    private BigDecimal cddAdministrationSkill;
    private BigDecimal cddDigitalSkill;

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
    public BigDecimal getCddSingleParent() {
        return cddSingleParent;
    }

    public void setCddSingleParent(BigDecimal cddSingleParent) {
        this.cddSingleParent = cddSingleParent;
    }

    @Basic
    @Column(name = "CDD_SINGLE", nullable = true, precision = 0)
    public BigDecimal getCddSingle() {
        return cddSingle;
    }

    public void setCddSingle(BigDecimal cddSingle) {
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
    public BigDecimal getCddJobless15To64() {
        return cddJobless15To64;
    }

    public void setCddJobless15To64(BigDecimal cddJobless15To64) {
        this.cddJobless15To64 = cddJobless15To64;
    }

    @Basic
    @Column(name = "CDD_PERSON_AGED_15_TO_29", nullable = true, precision = 0)
    public BigDecimal getCddPersonAged15To29() {
        return cddPersonAged15To29;
    }

    public void setCddPersonAged15To29(BigDecimal cddPersonAged15To29) {
        this.cddPersonAged15To29 = cddPersonAged15To29;
    }

    @Basic
    @Column(name = "CDD_PERSON_AGED_OVER_65", nullable = true, precision = 0)
    public BigDecimal getCddPersonAgedOver65() {
        return cddPersonAgedOver65;
    }

    public void setCddPersonAgedOver65(BigDecimal cddPersonAgedOver65) {
        this.cddPersonAgedOver65 = cddPersonAgedOver65;
    }

    @Basic
    @Column(name = "CDD_NO_DIPLOMA_OVER_15", nullable = true, precision = 0)
    public BigDecimal getCddNoDiplomaOver15() {
        return cddNoDiplomaOver15;
    }

    public void setCddNoDiplomaOver15(BigDecimal cddNoDiplomaOver15) {
        this.cddNoDiplomaOver15 = cddNoDiplomaOver15;
    }

    @Basic
    @Column(name = "CDD_DEPARTMENT_ID", nullable = false)
    public long getCddDepartementId() {
        return cddDepartementId;
    }

    public void setCddDepartementId(long cddDepartementId) {
        this.cddDepartementId = cddDepartementId;
    }

    @Basic
    @Column(name = "CDD_DIGITAL_INTERFACE", nullable = true, precision = 4)
	public BigDecimal getCddDigitalInterface() {
		return cddDigitalInterface;
        }

	public void setCddDigitalInterface(BigDecimal cddDigitalInterface) {
		this.cddDigitalInterface = cddDigitalInterface;
        }
	
	@Basic
    @Column(name = "CDD_INFORMATION_ACCESS", nullable = true, precision = 4)
	public BigDecimal getCddInformationAccess() {
		return cddInformationAccess;
	}

	public void setCddInformationAccess(BigDecimal cddInformationAccess) {
		this.cddInformationAccess = cddInformationAccess;
    }

	@Basic
    @Column(name = "CDD_ADMISTRATION_SKILL", nullable = true, precision = 4)
	public BigDecimal getCddAdministrationSkill() {
		return cddAdministrationSkill;
	}

	public void setCddAdministrationSkill(BigDecimal cddAdministrationSkill) {
		this.cddAdministrationSkill = cddAdministrationSkill;
	}
	
	@Basic
    @Column(name = "CDD_DIGITAL_SCRILL", nullable = true, precision = 4)
	public BigDecimal getCddDigitalSkill() {
		return cddDigitalSkill;
	}

	public void setCddDigitalSkill(BigDecimal cddDigitalSkill) {
		this.cddDigitalSkill = cddDigitalSkill;
	}
	
	public DepartmentDigitalScoringModel toDepartmentDigitalScoringModel() {
		DepartmentDigitalScoringModel departmentDigitalScoringModel = new DepartmentDigitalScoringModel();
		
		departmentDigitalScoringModel.setCddAdministrationSkill(cddAdministrationSkill);
		departmentDigitalScoringModel.setCddDepartementId(cddDepartementId);
		departmentDigitalScoringModel.setCddDigitalInterface(cddDigitalInterface);
		departmentDigitalScoringModel.setCddDigitalSkill(cddDigitalSkill);
		departmentDigitalScoringModel.setCddInformationAccess(cddInformationAccess);

		BigDecimal scoring = BigDecimal.ZERO;
		int index=0;
		if(cddAdministrationSkill!=null) {
			scoring=scoring.add(cddAdministrationSkill);
			index++;
		}
		if(cddDigitalInterface!=null) {
			scoring=scoring.add(cddDigitalInterface);
			index++;
		}
		if(cddDigitalSkill!=null) {
			scoring=scoring.add(cddDigitalSkill);
			index++;
		}
		if(cddInformationAccess!=null) {
			scoring=scoring.add(cddInformationAccess);
			index++;
		}
		if(index > 0) {
			departmentDigitalScoringModel.setScoring(scoring.divide(BigDecimal.valueOf(index)));
		}
		
		
		return departmentDigitalScoringModel;
	}
	
    @Override
    public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cddAdministrationSkill == null) ? 0 : cddAdministrationSkill.hashCode());
		result = prime * result + (int) (cddDepartementId ^ (cddDepartementId >>> 32));
		result = prime * result + ((cddDigitalInterface == null) ? 0 : cddDigitalInterface.hashCode());
		result = prime * result + ((cddDigitalSkill == null) ? 0 : cddDigitalSkill.hashCode());
		result = prime * result + (int) (cddId ^ (cddId >>> 32));
		result = prime * result + ((cddInformationAccess == null) ? 0 : cddInformationAccess.hashCode());
		result = prime * result + ((cddJobless15To64 == null) ? 0 : cddJobless15To64.hashCode());
		result = prime * result + ((cddLegalPopulation == null) ? 0 : cddLegalPopulation.hashCode());
		result = prime * result + ((cddMedianIncome == null) ? 0 : cddMedianIncome.hashCode());
		result = prime * result + ((cddMobilityCoverageRate2G == null) ? 0 : cddMobilityCoverageRate2G.hashCode());
		result = prime * result + ((cddNetworkRateCoverage == null) ? 0 : cddNetworkRateCoverage.hashCode());
		result = prime * result + ((cddNoDiplomaOver15 == null) ? 0 : cddNoDiplomaOver15.hashCode());
		result = prime * result + ((cddPersonAged15To29 == null) ? 0 : cddPersonAged15To29.hashCode());
		result = prime * result + ((cddPersonAgedOver65 == null) ? 0 : cddPersonAgedOver65.hashCode());
		result = prime * result + ((cddPovertyRate == null) ? 0 : cddPovertyRate.hashCode());
		result = prime * result + ((cddPublicService == null) ? 0 : cddPublicService.hashCode());
		result = prime * result + ((cddPublicServicePerPerson == null) ? 0 : cddPublicServicePerPerson.hashCode());
		result = prime * result + ((cddSingle == null) ? 0 : cddSingle.hashCode());
		result = prime * result + ((cddSingleParent == null) ? 0 : cddSingleParent.hashCode());
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
		DepartmentDigitalScoring other = (DepartmentDigitalScoring) obj;
		if (cddAdministrationSkill == null) {
			if (other.cddAdministrationSkill != null)
				return false;
		} else if (!cddAdministrationSkill.equals(other.cddAdministrationSkill))
			return false;
		if (cddDepartementId != other.cddDepartementId)
			return false;
		if (cddDigitalInterface == null) {
			if (other.cddDigitalInterface != null)
				return false;
		} else if (!cddDigitalInterface.equals(other.cddDigitalInterface))
			return false;
		if (cddDigitalSkill == null) {
			if (other.cddDigitalSkill != null)
				return false;
		} else if (!cddDigitalSkill.equals(other.cddDigitalSkill))
			return false;
		if (cddId != other.cddId)
			return false;
		if (cddInformationAccess == null) {
			if (other.cddInformationAccess != null)
				return false;
		} else if (!cddInformationAccess.equals(other.cddInformationAccess))
			return false;
		if (cddJobless15To64 == null) {
			if (other.cddJobless15To64 != null)
				return false;
		} else if (!cddJobless15To64.equals(other.cddJobless15To64))
			return false;
		if (cddLegalPopulation == null) {
			if (other.cddLegalPopulation != null)
				return false;
		} else if (!cddLegalPopulation.equals(other.cddLegalPopulation))
			return false;
		if (cddMedianIncome == null) {
			if (other.cddMedianIncome != null)
				return false;
		} else if (!cddMedianIncome.equals(other.cddMedianIncome))
			return false;
		if (cddMobilityCoverageRate2G == null) {
			if (other.cddMobilityCoverageRate2G != null)
				return false;
		} else if (!cddMobilityCoverageRate2G.equals(other.cddMobilityCoverageRate2G))
			return false;
		if (cddNetworkRateCoverage == null) {
			if (other.cddNetworkRateCoverage != null)
				return false;
		} else if (!cddNetworkRateCoverage.equals(other.cddNetworkRateCoverage))
			return false;
		if (cddNoDiplomaOver15 == null) {
			if (other.cddNoDiplomaOver15 != null)
				return false;
		} else if (!cddNoDiplomaOver15.equals(other.cddNoDiplomaOver15))
			return false;
		if (cddPersonAged15To29 == null) {
			if (other.cddPersonAged15To29 != null)
				return false;
		} else if (!cddPersonAged15To29.equals(other.cddPersonAged15To29))
			return false;
		if (cddPersonAgedOver65 == null) {
			if (other.cddPersonAgedOver65 != null)
				return false;
		} else if (!cddPersonAgedOver65.equals(other.cddPersonAgedOver65))
			return false;
		if (cddPovertyRate == null) {
			if (other.cddPovertyRate != null)
				return false;
		} else if (!cddPovertyRate.equals(other.cddPovertyRate))
			return false;
		if (cddPublicService == null) {
			if (other.cddPublicService != null)
				return false;
		} else if (!cddPublicService.equals(other.cddPublicService))
			return false;
		if (cddPublicServicePerPerson == null) {
			if (other.cddPublicServicePerPerson != null)
				return false;
		} else if (!cddPublicServicePerPerson.equals(other.cddPublicServicePerPerson))
			return false;
		if (cddSingle == null) {
			if (other.cddSingle != null)
				return false;
		} else if (!cddSingle.equals(other.cddSingle))
			return false;
		if (cddSingleParent == null) {
			if (other.cddSingleParent != null)
				return false;
		} else if (!cddSingleParent.equals(other.cddSingleParent))
			return false;
		return true;
	}

}
