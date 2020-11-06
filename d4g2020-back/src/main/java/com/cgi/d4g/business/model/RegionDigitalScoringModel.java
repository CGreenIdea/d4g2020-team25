package com.cgi.d4g.business.model;

import java.math.BigDecimal;

public class RegionDigitalScoringModel {
    private BigDecimal cdrDigitalInterface;
    private BigDecimal cdrInformationAccess;
    private BigDecimal cdrAdministrationSkill;
    private BigDecimal cdrDigitalSkill;
    
    public RegionDigitalScoringModel() {
    	
    }
    
    /**
     * The region scoring constructor
     */
    public RegionDigitalScoringModel(BigDecimal cdrDigitalInterface, BigDecimal cdrInformationAccess,
		     BigDecimal cdrAdministrationSkill, BigDecimal cdrDigitalSkill) {
		super();
		this.cdrDigitalInterface = cdrDigitalInterface;
		this.cdrInformationAccess = cdrInformationAccess;
		this.cdrAdministrationSkill = cdrAdministrationSkill;
		this.cdrDigitalSkill = cdrDigitalSkill;
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
