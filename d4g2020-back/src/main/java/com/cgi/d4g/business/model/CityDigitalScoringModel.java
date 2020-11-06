package com.cgi.d4g.business.model;

import java.math.BigDecimal;

public class CityDigitalScoringModel {
    private BigDecimal cdsDigitalInterface;
    private BigDecimal cdsInformationAccess;
    private BigDecimal cdsAdministrationSkill;
    private BigDecimal cdsDigitalSkill;
    private BigDecimal scoring;

    /**
	 * @return the scoring
	 */
	public BigDecimal getScoring() {
		return scoring;
	}

	/**
	 * @param scoring the scoring to set
	 */
	public void setScoring(BigDecimal scoring) {
		this.scoring = scoring;
	}

	public BigDecimal getCdsDigitalInterface() {
        return cdsDigitalInterface;
    }

    public void setCdsDigitalInterface(BigDecimal cdsDigitalInterface) {
        this.cdsDigitalInterface = cdsDigitalInterface;
    }

    public BigDecimal getCdsInformationAccess() {
        return cdsInformationAccess;
    }

    public void setCdsInformationAccess(BigDecimal cdsInformationAccess) {
        this.cdsInformationAccess = cdsInformationAccess;
    }

    public BigDecimal getCdsAdministrationSkill() {
        return cdsAdministrationSkill;
    }

    public void setCdsAdministrationSkill(BigDecimal cdsAdministrationSkill) {
        this.cdsAdministrationSkill = cdsAdministrationSkill;
    }

    public BigDecimal getCdsDigitalSkill() {
        return cdsDigitalSkill;
    }

    public void setCdsDigitalSkill(BigDecimal cdsDigitalSkill) {
        this.cdsDigitalSkill = cdsDigitalSkill;
    }


}
