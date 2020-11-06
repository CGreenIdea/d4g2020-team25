package com.cgi.d4g.business.model;

import java.math.BigDecimal;

public class DepartmentDigitalScoringModel {
    private long cddDepartementId;
    private BigDecimal cddDigitalInterface;
    private BigDecimal cddInformationAccess;
    private BigDecimal cddAdministrationSkill;
    private BigDecimal cddDigitalSkill;


    public long getCddDepartementId() {
        return cddDepartementId;
    }

    public void setCddDepartementId(long cddDepartementId) {
        this.cddDepartementId = cddDepartementId;
    }

	public BigDecimal getCddDigitalInterface() {
		return cddDigitalInterface;
        }

	public void setCddDigitalInterface(BigDecimal cddDigitalInterface) {
		this.cddDigitalInterface = cddDigitalInterface;
        }
	
	public BigDecimal getCddInformationAccess() {
		return cddInformationAccess;
	}

	public void setCddInformationAccess(BigDecimal cddInformationAccess) {
		this.cddInformationAccess = cddInformationAccess;
    }

	public BigDecimal getCddAdministrationSkill() {
		return cddAdministrationSkill;
	}

	public void setCddAdministrationSkill(BigDecimal cddAdministrationSkill) {
		this.cddAdministrationSkill = cddAdministrationSkill;
	}
	
	public BigDecimal getCddDigitalSkill() {
		return cddDigitalSkill;
	}

	public void setCddDigitalSkill(BigDecimal cddDigitalSkill) {
		this.cddDigitalSkill = cddDigitalSkill;
	}



}
