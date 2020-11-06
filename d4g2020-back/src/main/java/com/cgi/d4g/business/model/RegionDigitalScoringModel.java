package com.cgi.d4g.business.model;

import java.math.BigDecimal;

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
    private int cdrDepartmentId;
    private BigDecimal cdrDigitalInterface;
    private BigDecimal cdrInformationAccess;
    private BigDecimal cdrAdministrationSkill;
    private BigDecimal cdrDigitalSkill;
    
    public RegionDigitalScoringModel() {
    	
    }
    
    /**
     * The region scoring constructor
     * @param cdrLegalPopulation the legal population
     * @param cdrNetworkRateCoverage the network rate coverage
     * @param cdrMobilityCoverageRate2G the mobility coverage rate of 2G
     * @param cdrPovertyRate the poverty rate
     * @param cdrMedianIncome the median income 
     * @param cdrSingleParent the single parent values
     * @param cdrSingle the single values 
     * @param cdrPublicServicePerPerson the public service per person values
     * @param cdrPublicService the public service values
     * @param cdrJobless15To64 the jobless values for person from 15 to 64 year
     * @param cdrPersonAged15To29 the number of person from 15 to 29 year
     * @param cdrPersonAgedOver65 the number of person aged over 65
     * @param cdrNoDiplomaOver15 the number of person with no diploma of over 15 year
     * @param cdrDepartmentId the department id.
     */
    public RegionDigitalScoringModel(Integer cdrLegalPopulation, BigDecimal cdrNetworkRateCoverage,
			BigDecimal cdrMobilityCoverageRate2G, BigDecimal cdrPovertyRate, BigDecimal cdrMedianIncome,
			Integer cdrSingleParent, Integer cdrSingle, BigDecimal cdrPublicServicePerPerson,
			BigDecimal cdrPublicService, Integer cdrJobless15To64, Integer cdrPersonAged15To29,
			Integer cdrPersonAgedOver65, Integer cdrNoDiplomaOver15, int cdrDepartmentId,
		     BigDecimal cdrDigitalInterface, BigDecimal cdrInformationAccess,
		     BigDecimal cdrAdministrationSkill, BigDecimal cdrDigitalSkill) {
		super();
		this.cdrLegalPopulation = cdrLegalPopulation;
		this.cdrNetworkRateCoverage = cdrNetworkRateCoverage;
		this.cdrMobilityCoverageRate2G = cdrMobilityCoverageRate2G;
		this.cdrPovertyRate = cdrPovertyRate;
		this.cdrMedianIncome = cdrMedianIncome;
		this.cdrSingleParent = cdrSingleParent;
		this.cdrSingle = cdrSingle;
		this.cdrPublicServicePerPerson = cdrPublicServicePerPerson;
		this.cdrPublicService = cdrPublicService;
		this.cdrJobless15To64 = cdrJobless15To64;
		this.cdrPersonAged15To29 = cdrPersonAged15To29;
		this.cdrPersonAgedOver65 = cdrPersonAgedOver65;
		this.cdrNoDiplomaOver15 = cdrNoDiplomaOver15;
		this.cdrDepartmentId = cdrDepartmentId;
		this.cdrDigitalInterface = cdrDigitalInterface;
		this.cdrInformationAccess = cdrInformationAccess;
		this.cdrAdministrationSkill = cdrAdministrationSkill;
		this.cdrDigitalSkill = cdrDigitalSkill;
	}

	public Integer getCdrLegalPopulation() {
        return cdrLegalPopulation;
    }

    public void setCdrLegalPopulation(Integer cdrLegalPopulation) {
        this.cdrLegalPopulation = cdrLegalPopulation;
    }

    public BigDecimal getCdrNetworkRateCoverage() {
        return cdrNetworkRateCoverage;
    }

    public void setCdrNetworkRateCoverage(BigDecimal cdrNetworkRateCoverage) {
        this.cdrNetworkRateCoverage = cdrNetworkRateCoverage;
    }

    public BigDecimal getCdrMobilityCoverageRate2G() {
        return cdrMobilityCoverageRate2G;
    }

    public void setCdrMobilityCoverageRate2G(BigDecimal cdrMobilityCoverageRate2G) {
        this.cdrMobilityCoverageRate2G = cdrMobilityCoverageRate2G;
    }

    public BigDecimal getCdrPovertyRate() {
        return cdrPovertyRate;
    }

    public void setCdrPovertyRate(BigDecimal cdrPovertyRate) {
        this.cdrPovertyRate = cdrPovertyRate;
    }

    public BigDecimal getCdrMedianIncome() {
        return cdrMedianIncome;
    }

    public void setCdrMedianIncome(BigDecimal cdrMedianIncome) {
        this.cdrMedianIncome = cdrMedianIncome;
    }

    public Integer getCdrSingleParent() {
        return cdrSingleParent;
    }

    public void setCdrSingleParent(Integer cdrSingleParent) {
        this.cdrSingleParent = cdrSingleParent;
    }

    public Integer getCdrSingle() {
        return cdrSingle;
    }

    public void setCdrSingle(Integer cdrSingle) {
        this.cdrSingle = cdrSingle;
    }

    public BigDecimal getCdrPublicServicePerPerson() {
        return cdrPublicServicePerPerson;
    }

    public void setCdrPublicServicePerPerson(BigDecimal cdrPublicServicePerPerson) {
        this.cdrPublicServicePerPerson = cdrPublicServicePerPerson;
    }

    public BigDecimal getCdrPublicService() {
        return cdrPublicService;
    }

    public void setCdrPublicService(BigDecimal cdrPublicService) {
        this.cdrPublicService = cdrPublicService;
    }

    public Integer getCdrJobless15To64() {
        return cdrJobless15To64;
    }

    public void setCdrJobless15To64(Integer cdrJobless15To64) {
        this.cdrJobless15To64 = cdrJobless15To64;
    }

    public Integer getCdrPersonAged15To29() {
        return cdrPersonAged15To29;
    }

    public void setCdrPersonAged15To29(Integer cdrPersonAged15To29) {
        this.cdrPersonAged15To29 = cdrPersonAged15To29;
    }

    public Integer getCdrPersonAgedOver65() {
        return cdrPersonAgedOver65;
    }

    public void setCdrPersonAgedOver65(Integer cdrPersonAgedOver65) {
        this.cdrPersonAgedOver65 = cdrPersonAgedOver65;
    }

    public Integer getCdrNoDiplomaOver15() {
        return cdrNoDiplomaOver15;
    }

    public void setCdrNoDiplomaOver15(Integer cdrNoDiplomaOver15) {
        this.cdrNoDiplomaOver15 = cdrNoDiplomaOver15;
    }

    public int getCdrDepartmentId() {
        return cdrDepartmentId;
    }

    public void setCdrDepartmentId(int cdrDepartmentId) {
        this.cdrDepartmentId = cdrDepartmentId;
    }

	public BigDecimal getCdrDigitalInterface() {
		return cdrDigitalInterface;
        }

	public void setCdrDigitalInterface(BigDecimal cdrDigitalInterface) {
		this.cdrDigitalInterface = cdrDigitalInterface;
        }
	
	public BigDecimal getCdrInformationAccess() {
		return cdrInformationAccess;
    }

	public void setCdrInformationAccess(BigDecimal cdrInformationAccess) {
		this.cdrInformationAccess = cdrInformationAccess;
	}
	
	public BigDecimal getCdrAdministrationSkill() {
		return cdrAdministrationSkill;
    }

	public void setCdrAdministrationSkill(BigDecimal cdrAdministrationSkill) {
		this.cdrAdministrationSkill = cdrAdministrationSkill;
	}
	
	public BigDecimal getCdrDigitalSkill() {
		return cdrDigitalSkill;
	}

	public void setCdrDigitalSkill(BigDecimal cdrDigitalSkill) {
		this.cdrDigitalSkill = cdrDigitalSkill;
	}

}
