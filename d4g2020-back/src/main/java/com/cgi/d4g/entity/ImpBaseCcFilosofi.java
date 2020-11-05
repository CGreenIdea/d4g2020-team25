package com.cgi.d4g.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "IMP_BASE_CC_FILOSOFI", schema = "d4g_ifn", catalog = "")
public class ImpBaseCcFilosofi {
    private long flfId;
    private String flfCodeArm;
    private BigDecimal flfPovertyRate;
    private BigDecimal flfMedianIncome;

    @Id
    @Column(name = "FLF_ID", nullable = false)
    public long getFlfId() {
        return flfId;
    }

    public void setFlfId(long flfId) {
        this.flfId = flfId;
    }

    @Basic
    @Column(name = "FLF_CODE_ARM", nullable = false, length = 5)
    public String getFlfCodeArm() {
        return flfCodeArm;
    }

    public void setFlfCodeArm(String flfCodeArm) {
        this.flfCodeArm = flfCodeArm;
    }

    @Basic
    @Column(name = "FLF_POVERTY_RATE", nullable = true, precision = 4)
    public BigDecimal getFlfPovertyRate() {
        return flfPovertyRate;
    }

    public void setFlfPovertyRate(BigDecimal flfPovertyRate) {
        this.flfPovertyRate = flfPovertyRate;
    }

    @Basic
    @Column(name = "FLF_MEDIAN_INCOME", nullable = true, precision = 4)
    public BigDecimal getFlfMedianIncome() {
        return flfMedianIncome;
    }

    public void setFlfMedianIncome(BigDecimal flfMedianIncome) {
        this.flfMedianIncome = flfMedianIncome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImpBaseCcFilosofi that = (ImpBaseCcFilosofi) o;
        return flfId == that.flfId &&
            Objects.equals(flfCodeArm, that.flfCodeArm) &&
            Objects.equals(flfPovertyRate, that.flfPovertyRate) &&
            Objects.equals(flfMedianIncome, that.flfMedianIncome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flfId, flfCodeArm, flfPovertyRate, flfMedianIncome);
    }
}
