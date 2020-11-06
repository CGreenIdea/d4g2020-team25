package com.cgi.d4g.business.model;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CityDigitalScoringModel {
    private BigDecimal cdsDigitalInterface;
    private BigDecimal cdsInformationAccess;
    private BigDecimal cdsAdministrationSkill;
    private BigDecimal cdsDigitalSkill;



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


}
