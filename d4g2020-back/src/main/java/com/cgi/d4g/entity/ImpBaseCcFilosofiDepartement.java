package com.cgi.d4g.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "IMP_BASE_CC_FILOSOFI_DEPARTEMENT", schema = "d4g_ifn", catalog = "")
public class ImpBaseCcFilosofiDepartement {
    private int fldId;
    private String fldCode;
    private BigDecimal fldPovertyRate;
    private BigDecimal fldSocialAid;
    private BigDecimal fldMedianIncome;

    @Id
    @Column(name = "FLD_ID", nullable = false)
    public int getFldId() {
        return fldId;
    }

    public void setFldId(int fldId) {
        this.fldId = fldId;
    }

    @Basic
    @Column(name = "FLD_CODE", nullable = false, length = 5)
    public String getFldCode() {
        return fldCode;
    }

    public void setFldCode(String fldCode) {
        this.fldCode = fldCode;
    }

    @Basic
    @Column(name = "FLD_POVERTY_RATE", nullable = true, precision = 4)
    public BigDecimal getFldPovertyRate() {
        return fldPovertyRate;
    }

    public void setFldPovertyRate(BigDecimal fldPovertyRate) {
        this.fldPovertyRate = fldPovertyRate;
    }

    @Basic
    @Column(name = "FLD_SOCIAL_AID", nullable = true, precision = 4)
    public BigDecimal getFldSocialAid() {
        return fldSocialAid;
    }

    public void setFldSocialAid(BigDecimal fldSocialAid) {
        this.fldSocialAid = fldSocialAid;
    }

    @Basic
    @Column(name = "FLD_MEDIAN_INCOME", nullable = true, precision = 4)
    public BigDecimal getFldMedianIncome() {
        return fldMedianIncome;
    }

    public void setFldMedianIncome(BigDecimal fldMedianIncome) {
        this.fldMedianIncome = fldMedianIncome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImpBaseCcFilosofiDepartement that = (ImpBaseCcFilosofiDepartement) o;
        return fldId == that.fldId &&
            Objects.equals(fldCode, that.fldCode) &&
            Objects.equals(fldPovertyRate, that.fldPovertyRate) &&
            Objects.equals(fldSocialAid, that.fldSocialAid) &&
            Objects.equals(fldMedianIncome, that.fldMedianIncome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fldId, fldCode, fldPovertyRate, fldSocialAid, fldMedianIncome);
    }
}